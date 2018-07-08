package pl.pmierkowski.bookssearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pmierkowski.bookssearch.model.BookOffer;
import pl.pmierkowski.bookssearch.model.BookOfferFactory;
import pl.pmierkowski.bookssearch.model.BookOfferList;
import pl.pmierkowski.bookssearch.model.ebay.FindItemsByProductResponseType;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import pl.pmierkowski.bookssearch.repository.CurrencyRestRepository;
import pl.pmierkowski.bookssearch.repository.EbayRestRepository;
import pl.pmierkowski.bookssearch.repository.GoogleBooksRestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksSearchService {

    public static final String REQUIRED_GOOGLE_TYPE = "ISBN_13";

    private GoogleBooksRestRepository googleBooksRestRepository;
    private EbayRestRepository ebayRestRepository;
    private CurrencyRestRepository currencyRestRepository;
    private BookOfferFactory bookOfferFactory;

    @Autowired
    public BooksSearchService(
            GoogleBooksRestRepository googleBooksRestRepository,
            EbayRestRepository ebayRestRepository,
            CurrencyRestRepository currencyRestRepository,
            BookOfferFactory bookOfferFactory) {

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

        BookOffer bestBookOffer = this.getBestBookOffer(bookOffers);
        bookOffers.remove(bestBookOffer);
        return new BookOfferList(bestBookOffer, bookOffers);
    }

    private BookOffer getBestBookOffer(List<BookOffer> bookOffers) {
        if(bookOffers.size() == 0){
            return null;
        }

        BookOffer bestBookOffer = bookOffers.stream().findFirst().get();
        Double bestPrice = Double.POSITIVE_INFINITY;

        for (BookOffer bookOffer : bookOffers) {
            if (bookOffer.isForSale() && bookOffer.getLocalPriceWithShipment() < bestPrice) {
                bestPrice = bookOffer.getLocalPriceWithShipment();
                bestBookOffer = bookOffer;
            }
        }

        return bestBookOffer;
    }
}
