package pl.pmierkowski.bookssearch.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@EnableCaching
@Configuration
public class CacheConfiguration {

    public static final String GOOGLE_BOOK_SEARCH = "googleBookSearch";
    public static final String EBAY_BOOK_SEARCH = "ebayBookSearch";
    public static final String CURRENCY_SEARCH = "currencySearch";

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache(CacheConfiguration.GOOGLE_BOOK_SEARCH),
                new ConcurrentMapCache(CacheConfiguration.EBAY_BOOK_SEARCH),
                new ConcurrentMapCache(CacheConfiguration.CURRENCY_SEARCH)
        ));

        return cacheManager;
    }
}
