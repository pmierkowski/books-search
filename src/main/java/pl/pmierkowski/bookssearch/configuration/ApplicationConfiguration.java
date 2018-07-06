package pl.pmierkowski.bookssearch.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("googleApiBooks")
    public UriComponentsBuilder uriComponentsBuilder(@Value("${google.api.rest.booksUrl}") String url) {
        return UriComponentsBuilder.fromHttpUrl(url);
    }
}
