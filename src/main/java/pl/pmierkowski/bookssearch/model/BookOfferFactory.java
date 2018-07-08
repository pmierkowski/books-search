package pl.pmierkowski.bookssearch.model;

import pl.pmierkowski.bookssearch.model.ebay.FindItemsByProductResponseType;
import pl.pmierkowski.bookssearch.model.ebay.ItemType;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import pl.pmierkowski.bookssearch.model.google.Item;
import pl.pmierkowski.bookssearch.repository.CurrencyRestRepository;
import pl.pmierkowski.bookssearch.service.BooksSearchService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

public class BookOfferFactory {

    private final Currency localCurrency;

    public BookOfferFactory(String localCurrency) {
        this.localCurrency = Currency.getInstance(localCurrency);
    }

    public List<BookOffer> fromEbay(FindItemsByProductResponseType findItemsByProductResponseType, String isbn, CurrencyRestRepository currencyRestRepository) {
        List<BookOffer> bookOffers = new ArrayList<>();

        if (!Objects.isNull(findItemsByProductResponseType.getSearchResult()) && !Objects.isNull(findItemsByProductResponseType.getSearchResult().getItem())) {
            for (ItemType itemType : findItemsByProductResponseType.getSearchResult().getItem()) {
                Currency currency = Currency.getInstance(itemType.getSellingStatus().getCurrentPrice().getCurrencyId());
                Double price = Double.parseDouble(Float.toString(itemType.getSellingStatus().getCurrentPrice().getValue()));

                Currency shippingCurrency = Currency.getInstance(itemType.getShippingInfo().getShippingServiceCost().getCurrencyId());
                Double shippingCost = Double.parseDouble(Float.toString(itemType.getShippingInfo().getShippingServiceCost().getValue()));

                Double localPrice = price * currencyRestRepository.getExchangeRates(currency, this.localCurrency) +
                        shippingCost * currencyRestRepository.getExchangeRates(shippingCurrency, this.localCurrency);

                BookOffer bookOffer = new BookOffer();

                bookOffer.setSeller(Seller.Ebay);
                bookOffer.setTitle(itemType.getTitle());
                bookOffer.setSubtitle(itemType.getSubtitle());
                bookOffer.setThumbnailUrl(itemType.getGalleryURL());
                bookOffer.setIsbn(isbn);//Ebay don't return isbn, but we search by isbn, so we have it
                bookOffer.setCurrency(currency);
                bookOffer.setPrice(price);
                bookOffer.setShippingCurrency(shippingCurrency);
                bookOffer.setShippingCost(shippingCost);
                bookOffer.setLocalCurrency(this.localCurrency);
                bookOffer.setForSale(true);
                bookOffer.setBuyUrl(itemType.getViewItemURL());
                bookOffer.setLocalPriceWithShipment(round(localPrice, 2));

                bookOffers.add(bookOffer);
            }
        }

        return bookOffers;
    }

    public List<BookOffer> fromGoogleBooks(GoogleBooks googleBooks, CurrencyRestRepository currencyRestRepository) {
        List<BookOffer> bookOffers = new ArrayList<>();

        if (!Objects.isNull(googleBooks.getItems())) {
            for (Item item : googleBooks.getItems()) {

                BookOffer bookOffer = new BookOffer();

                bookOffer.setSeller(Seller.Google);
                bookOffer.setTitle(item.getVolumeInfo().getTitle());
                bookOffer.setSubtitle(item.getVolumeInfo().getSubtitle());
                bookOffer.setThumbnailUrl(item.getVolumeInfo().getImageLinks().getThumbnail());
                bookOffer.setIsbn(
                        item.getVolumeInfo().getIndustryIdentifiers().
                                stream().
                                filter(x -> x.getType().equals(BooksSearchService.REQUIRED_GOOGLE_TYPE))
                                .findFirst()
                                .get()
                                .getIdentifier()
                );
                bookOffer.setShippingCost(0.0);//In google books there are only e-books to buy
                bookOffer.setLocalCurrency(this.localCurrency);
                bookOffer.setBuyUrl(item.getVolumeInfo().getInfoLink());

                if (item.getSaleInfo().getRetailPrice() != null) {
                    Currency currency = Currency.getInstance(item.getSaleInfo().getRetailPrice().getCurrencyCode());
                    Double price = item.getSaleInfo().getRetailPrice().getAmount();

                    bookOffer.setCurrency(currency);
                    bookOffer.setPrice(price);
                    bookOffer.setShippingCurrency(currency);
                    bookOffer.setForSale(true);

                    Double localPrice = price * currencyRestRepository.getExchangeRates(currency, this.localCurrency);

                    bookOffer.setLocalPriceWithShipment(round(localPrice, 2));
                } else {
                    bookOffer.setForSale(false);
                }

                bookOffers.add(bookOffer);
            }
        }

        return bookOffers;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
