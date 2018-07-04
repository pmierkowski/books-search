package pl.pmierkowski.bookssearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.pmierkowski.bookssearch.model.google.GoogleBooksWrapper;

@Repository
public class GoogleBooksRestRepository {

    private RestTemplate restTemplate;

    @Autowired
    public GoogleBooksRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void searchBooks(String query){
        GoogleBooksWrapper googleBooksWrapper =
                this.restTemplate.getForObject("https://www.googleapis.com/books/v1/volumes?q=title:" + query, GoogleBooksWrapper.class);

        System.out.println(googleBooksWrapper.toString());
    }
}
