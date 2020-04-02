package hugsoul.youtube;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class YoutubeSearch {
   private int maxResults = 10;
   private String pageToken;
   private String regionCode = "us";
   @NotBlank
   private String category; 
}
