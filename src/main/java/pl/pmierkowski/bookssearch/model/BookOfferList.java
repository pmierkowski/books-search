package pl.pmierkowski.bookssearch.model;

import java.util.List;

public class BookOfferList {
    private BookOffer bestOffer;
    private List<BookOffer> otherOffers;

    public BookOfferList(BookOffer bestOffer, List<BookOffer> otherOffers) {
        this.bestOffer = bestOffer;
        this.otherOffers = otherOffers;
    }

    public BookOffer getBestOffer() {
        return bestOffer;
    }

    public List<BookOffer> getOtherOffers() {
        return otherOffers;
    }
}
