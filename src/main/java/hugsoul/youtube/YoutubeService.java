package hugsoul.youtube;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class YoutubeService {
    
    //TODO
    @GetMapping
    List<YoutubeResponseDTO> getVideos() {
        List<YoutubeResponseDTO> videos = new ArrayList<>();
        videos.add(new YoutubeResponseDTO());
        return videos;
    }

}
