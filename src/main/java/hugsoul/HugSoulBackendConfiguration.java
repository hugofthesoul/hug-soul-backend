package hugsoul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HugSoulBackendConfiguration {
    
    @Bean
    RestTemplate youtubeTemplate() {
        return new RestTemplate();
    }
}
