package hugsoul.youtube;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.var;

@Service
public class YoutubeService {

    @Autowired
    RestTemplate youtubeTemplate;
    
    @Value("${youtube.api.url}")
    String url;
    
    @Value("${youtube.api.key}")
    String apiKey;

    YoutubeApiResponse getVideos(YoutubeSearch search) {
        var params = new HashMap<String, Object>();
        // set invariant params ---------
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("key", apiKey)
            .queryParam("part", "id")
            .queryParam("order", "date")
            .queryParam("safeSearch", "strict")
            .queryParam("type", "video")
            .queryParam("videoDuration", "short")
            .queryParam("videoEmbeddable", "true");
        // set params based on the search param ---------
        // TODO:now either derive from country or additional search param
        builder.queryParam("relevanceLanguage", "en");
        // TODO map category to query
        builder.queryParam("q", search.getCategory());
        builder.queryParam("regionCode", search.getRegionCode());
        // dynamic params
        builder.queryParam("maxResults", search.getMaxResults());
        if (search.getPageToken() != null) {
            builder.queryParam("pageToken", search.getPageToken());
        }
        
        YoutubeApiResponse apiResponse = youtubeTemplate.getForObject(builder.toUriString(),
                YoutubeApiResponse.class, params);
        // TODO: maybe do some processing here
        return apiResponse;
    }
}
