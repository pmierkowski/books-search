package pl.pmierkowski.bookssearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pmierkowski.bookssearch.model.ebay.FindItemsByProductResponseType;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import pl.pmierkowski.bookssearch.repository.EbayRestRepository;
import pl.pmierkowski.bookssearch.repository.GoogleBooksRestRepository;

@Service
public class BooksSearchService {

    private GoogleBooksRestRepository googleBooksRestRepository;

    private EbayRestRepository ebayRestRepository;

    @Autowired
    public BooksSearchService(GoogleBooksRestRepository googleBooksRestRepository, EbayRestRepository ebayRestRepository) {
        this.googleBooksRestRepository = googleBooksRestRepository;
        this.ebayRestRepository = ebayRestRepository;
    }

    public GoogleBooks getByTitle(String title) {
        return this.googleBooksRestRepository.findByTitle(title);
    }

    public void getByIsbn(String isbn) {
        FindItemsByProductResponseType findItemsByProductResponseType = this.ebayRestRepository.findByIsbn(isbn);
    }
}
