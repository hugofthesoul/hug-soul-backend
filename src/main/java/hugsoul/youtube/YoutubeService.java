package hugsoul.youtube;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import hugsoul.exceptions.UnsupportedCountryException;
import lombok.Setter;
import lombok.var;

@Service
@ConfigurationProperties
@Setter
public class YoutubeService {

    @Autowired
    RestTemplate youtubeTemplate;

    @Value("${youtube.api.url}")
    String url;

    @Value("${youtube.api.key}")
    String apiKey;

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> playlistMap;

    Object getVideos(YoutubeSearch search) throws UnsupportedCountryException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("key", apiKey)
            .queryParam("part", "snippet")
            .queryParam("playlistId", getPlaylistId(search))
            .queryParam("maxResults", search.getMaxResults());
        if (search.getPageToken() != null) {
            builder.queryParam("pageToken", search.getPageToken());
        }
        return youtubeTemplate.getForObject(builder.toUriString(), Object.class);
    }

    private String getPlaylistId(YoutubeSearch search) throws UnsupportedCountryException {
        var categoryMap = playlistMap.get(search.getCategory());
        if (categoryMap == null) {
            throw new UnsupportedCountryException("Category not found: " + search.getCategory());
        }
        var countryMap = categoryMap.get(search.getCountryCode());
        if (countryMap == null) {
            throw new UnsupportedCountryException(
                    String.format("Unsupported country: %s for category: %s", search.getCountryCode(), search.getCategory()));
        }
        if (search.getLanguageCode() != null) {
            String result = countryMap.get(search.getLanguageCode());
            if (result != null) {
                return result;
            }
        }
        return countryMap.values().iterator().next();
    }
}
