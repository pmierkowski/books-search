package pl.pmierkowski.bookssearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pmierkowski.bookssearch.configuration.CacheConfiguration;
import pl.pmierkowski.bookssearch.model.ebay.FindItemsByProductResponseType;

import java.net.URI;

@Repository
public class EbayRestRepository {

    private final RestTemplate restTemplate;
    private final UriComponentsBuilder uriComponentsBuilder;

    @Autowired
    public EbayRestRepository(RestTemplate restTemplate, @Qualifier("ebayRestApiUriComponentsBuilder") UriComponentsBuilder uriComponentsBuilder) {
        this.restTemplate = restTemplate;
        this.uriComponentsBuilder = uriComponentsBuilder;
    }

    @Cacheable(CacheConfiguration.EBAY_BOOK_SEARCH)
    public FindItemsByProductResponseType findByIsbn(String isbn) {
        URI uri = this.uriComponentsBuilder
                .replaceQueryParam("OPERATION-NAME", "findItemsByProduct")
                .replaceQueryParam("productId.@type", "ISBN")
                .replaceQueryParam("productId", isbn)
                .replaceQueryParam("sortOrder", "PricePlusShippingLowest")
                .build()
                .toUri();

        return this.restTemplate.getForObject(uri, FindItemsByProductResponseType.class);
    }
}