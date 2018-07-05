package pl.pmierkowski.bookssearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import java.net.URI;

@Repository
@EnableCaching
public class GoogleBooksRestRepository {

    private RestTemplate restTemplate;

    private UriComponentsBuilder uriComponentsBuilder;

    @Autowired
    public GoogleBooksRestRepository(RestTemplate restTemplate, UriComponentsBuilder uriComponentsBuilder) {
        this.restTemplate = restTemplate;
        this.uriComponentsBuilder = uriComponentsBuilder;
    }

    @Cacheable(value = "searchBooksCache", cacheManager = "springCacheManager")
    public GoogleBooks searchBooks(String query) {
        URI uri = this.uriComponentsBuilder
                .queryParam("q", query)
                .build()
                .toUri();

        return this.restTemplate.getForObject(uri, GoogleBooks.class);
    }
}
