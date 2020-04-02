package hugsoul.youtube;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/videos")
public class YoutubeController {

    @Autowired
    YoutubeService youtubeService;

    @GetMapping
    YoutubeApiResponse getVideos(@Valid YoutubeSearch search) {
       return youtubeService.getVideos(search);
    }

}
