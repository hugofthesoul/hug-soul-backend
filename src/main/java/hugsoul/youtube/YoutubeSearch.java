package hugsoul.youtube;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class YoutubeSearch {
    /**
     * see https://countrycode.org/
     */
    @NotBlank
    private String countryCode;
    @NotBlank
    private String category;
    /**
     * https://de.wikipedia.org/wiki/Liste_der_ISO-639-1-Codes; optional: falls back to a default language for the specified country, if not
     * passed
     */
    private String languageCode;
    /**
     * Optional, see https://developers.google.com/youtube/v3/docs/playlistItems/list
     */
    private String pageToken;

    private int maxResults = 50;
}
