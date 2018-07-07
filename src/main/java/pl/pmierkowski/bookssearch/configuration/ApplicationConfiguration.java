package pl.pmierkowski.bookssearch.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pmierkowski.bookssearch.model.BookOfferFactory;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("googleRestApiUriComponentsBuilder")
    public UriComponentsBuilder googleApiUriComponentsBuilder(@Value("${google.api.rest.url}") String url) {
        return UriComponentsBuilder.fromHttpUrl(url);
    }

    @Bean("ebayRestApiUriComponentsBuilder")
    public UriComponentsBuilder ebayApiUriComponentsBuilder(
            @Value("${ebay.api.rest.url}") String url,
            @Value("${ebay.api.rest.securityAppName}") String securityAppName,
            @Value("${ebay.api.rest.version}") String version,
            @Value("${ebay.api.rest.format}") String format
    ) {
        return UriComponentsBuilder
                .fromHttpUrl(url)
                .replaceQueryParam("SECURITY-APPNAME", securityAppName)
                .replaceQueryParam("SERVICE-VERSION", version)
                .replaceQueryParam("RESPONSE-DATA-FORMAT", format)
                .replaceQueryParam("REST-PAYLOAD");
    }

    @Bean("currencyRestApiExchangeRates")
    public UriComponentsBuilder nbpApiUriComponentsBuilder(@Value("${currency.api.rest.url}") String url) {
        return UriComponentsBuilder
                .fromHttpUrl(url)
                .replaceQueryParam("compact", "y");
    }

    @Bean
    public BookOfferFactory bookOfferFactory(@Value("${currency.local}") String localCurrency){
        return new BookOfferFactory(localCurrency);
    }
}
