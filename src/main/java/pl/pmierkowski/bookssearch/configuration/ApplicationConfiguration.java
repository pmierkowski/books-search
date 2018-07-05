package pl.pmierkowski.bookssearch.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
@EnableCaching
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("googleApiBooks")
    public UriComponentsBuilder uriComponentsBuilder(@Value("${googleapis.rest.books.url}") String url) {
        return UriComponentsBuilder.fromHttpUrl(url);
    }

    @Bean(name = "springCacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("searchBooksCache");
    }
}
