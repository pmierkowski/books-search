package pl.pmierkowski.bookssearch.model;

import java.util.List;

public class BookOfferList {
    private BookOffer bestOffer;
    private List<BookOffer> otherOffers;



    public BookOffer getBestOffer() {
        return bestOffer;
    }

    public void setBestOffer(BookOffer bestOffer) {
        this.bestOffer = bestOffer;
    }

    public List<BookOffer> getOtherOffers() {
        return otherOffers;
    }

    public void setOtherOffers(List<BookOffer> otherOffers) {
        this.otherOffers = otherOffers;
    }
}
