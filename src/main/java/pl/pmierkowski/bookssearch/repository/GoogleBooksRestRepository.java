package pl.pmierkowski.bookssearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pmierkowski.bookssearch.configuration.CacheConfiguration;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;

import java.net.URI;

@Repository
public class GoogleBooksRestRepository {

    private final RestTemplate restTemplate;

    private final UriComponentsBuilder uriComponentsBuilder;

    @Autowired
    public GoogleBooksRestRepository(RestTemplate restTemplate, @Qualifier("googleRestApiUriComponentsBuilder") UriComponentsBuilder uriComponentsBuilder) {
        this.restTemplate = restTemplate;
        this.uriComponentsBuilder = uriComponentsBuilder;
    }

    @Cacheable(value = CacheConfiguration.GOOGLE_BOOK_SEARCH, cacheManager = CacheConfiguration.CACHE_MANAGER)
    public GoogleBooks findByTitle(String title) {
        URI uri = this.uriComponentsBuilder
                .replaceQueryParam("q", "title:" + title)
                .build()
                .toUri();

        return this.restTemplate.getForObject(uri, GoogleBooks.class);
    }

    public GoogleBooks findByIsbn(String isbn) {
        URI uri = this.uriComponentsBuilder
                .replaceQueryParam("q", "isbn:" + isbn)
                .build()
                .toUri();

        return this.restTemplate.getForObject(uri, GoogleBooks.class);
    }
}
