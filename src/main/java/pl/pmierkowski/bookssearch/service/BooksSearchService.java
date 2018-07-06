package pl.pmierkowski.bookssearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import pl.pmierkowski.bookssearch.repository.GoogleBooksRestRepository;

@Service
public class BooksSearchService {

    private GoogleBooksRestRepository googleBooksRestRepository;

    @Autowired
    public BooksSearchService(GoogleBooksRestRepository googleBooksRestRepository) {
        this.googleBooksRestRepository = googleBooksRestRepository;
    }

    public GoogleBooks getByTitle(String title) {
        return this.googleBooksRestRepository.findByTitle(title);
    }
}
