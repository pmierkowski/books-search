package pl.pmierkowski.bookssearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pmierkowski.bookssearch.model.BookOffer;
import pl.pmierkowski.bookssearch.model.BookOfferFactory;
import pl.pmierkowski.bookssearch.model.BookOfferList;
import pl.pmierkowski.bookssearch.model.ebay.FindItemsByProductResponseType;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import pl.pmierkowski.bookssearch.repository.EbayRestRepository;
import pl.pmierkowski.bookssearch.repository.GoogleBooksRestRepository;
import pl.pmierkowski.bookssearch.repository.CurrencyRestRepository;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Service
public class BooksSearchService {

    public static final String REQUIRED_GOOGLE_TYPE = "ISBN_13";

    private GoogleBooksRestRepository googleBooksRestRepository;
    private EbayRestRepository ebayRestRepository;
    private CurrencyRestRepository currencyRestRepository;
    private BookOfferFactory bookOfferFactory;

    @Autowired
    public BooksSearchService(GoogleBooksRestRepository googleBooksRestRepository, EbayRestRepository ebayRestRepository, CurrencyRestRepository currencyRestRepository, BookOfferFactory bookOfferFactory) {
        this.googleBooksRestRepository = googleBooksRestRepository;
        this.ebayRestRepository = ebayRestRepository;
        this.currencyRestRepository = currencyRestRepository;
        this.bookOfferFactory = bookOfferFactory;
    }

    public GoogleBooks getByTitle(String title) {
        return this.googleBooksRestRepository.findByTitle(title);
    }

    public BookOfferList getOffersByIsbn(String isbn) {
        FindItemsByProductResponseType findItemsByProductResponseType = this.ebayRestRepository.findByIsbn(isbn);
        GoogleBooks googleBooks = this.googleBooksRestRepository.findByIsbn(isbn);


        List<BookOffer> bookOffers = new ArrayList<>();
        bookOffers.addAll(this.bookOfferFactory.fromGoogleBooks(googleBooks, currencyRestRepository));
        bookOffers.addAll(this.bookOfferFactory.fromEbay(findItemsByProductResponseType, isbn, currencyRestRepository));

        BookOfferList bookOfferList = new BookOfferList();
        bookOfferList.setOtherOffers(bookOffers);
        bookOfferList.setBestOffer(this.getBestBookOffer(bookOffers));

        return bookOfferList;
    }

    private BookOffer getBestBookOffer(List<BookOffer> bookOffers){
        BookOffer bestBookOffer = bookOffers.get(0);
        Double bestPrice = Double.POSITIVE_INFINITY;

        for(BookOffer bookOffer: bookOffers){
            if(bookOffer.isForSale() && bookOffer.getLocalPriceWithShipment() < bestPrice){
                bestPrice = bookOffer.getLocalPriceWithShipment();
                bestBookOffer = bookOffer;
            }
        }

        return bestBookOffer;
    }
}
