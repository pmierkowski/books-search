package pl.pmierkowski.bookssearch.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pmierkowski.bookssearch.configuration.CacheConfiguration;
import pl.pmierkowski.bookssearch.exception.CurrencyApiDownException;

import java.io.IOException;
import java.net.URI;
import java.util.Currency;

@Repository
public class CurrencyRestRepository {
    private final RestTemplate restTemplate;
    private final UriComponentsBuilder uriComponentsBuilder;

    @Autowired
    public CurrencyRestRepository(RestTemplate restTemplate, @Qualifier("currencyRestApiExchangeRates") UriComponentsBuilder uriComponentsBuilder) {
        this.restTemplate = restTemplate;
        this.uriComponentsBuilder = uriComponentsBuilder;
    }

    @Cacheable(CacheConfiguration.CURRENCY_SEARCH)
    public Double getExchangeRates(Currency from, Currency to) {
        String queryKey = from.getCurrencyCode() + "_" + to.getCurrencyCode();

        URI uri = this.uriComponentsBuilder
                .replaceQueryParam("q", queryKey)
                .build()
                .toUri();

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (IOException e) {
            throw new CurrencyApiDownException();
        }
        JsonNode exchangeRate = root.path(queryKey).path("val");

        return Double.parseDouble(exchangeRate.toString());
    }
}
