package pl.pmierkowski.bookssearch.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfiguration {

    public static final String GOOGLE_BOOK_SEARCH = "googleBookSearch";
    public static final String CACHE_MANAGER = "concurrentMapCacheManager";

    @Bean(name = CACHE_MANAGER)
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(CacheConfiguration.GOOGLE_BOOK_SEARCH);
    }
}
