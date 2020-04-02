package hugsoul.youtube;

import java.util.List;

import lombok.Data;

@Data
public class YoutubeApiResponse {
    private String nextPageToken;
    private String regionCode;
    private PageInfo pageInfo;

    @Data
    public static class PageInfo {
        private long totalResults;
        private int resultsPerPage;
    }
    
    private List<Item> items;
    
    @Data
    public static class Item {
        private String kind;
        private String etag;
        private IdClass id;
        
        @Data
        public class IdClass {
            private String kind;
            private String videoId;
        }        
    }

}
