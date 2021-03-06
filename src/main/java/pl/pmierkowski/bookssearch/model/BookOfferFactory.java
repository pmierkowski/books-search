package pl.pmierkowski.bookssearch.model;

import com.google.common.base.Preconditions;
import pl.pmierkowski.bookssearch.model.ebay.FindItemsByProductResponseType;
import pl.pmierkowski.bookssearch.model.ebay.ItemType;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import pl.pmierkowski.bookssearch.model.google.Item;
import pl.pmierkowski.bookssearch.repository.CurrencyRestRepository;
import pl.pmierkowski.bookssearch.service.BooksSearchService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

public class BookOfferFactory {

    public static final int MIN_DECIMAL_PLACES = 0;
    public static final int LOCAL_PRICE_DECIMAL_PLACES = 2;
    public static final double NO_SHIPPING_COST = 0.0;

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

                Currency shippingCurrency = !Objects.isNull(itemType.getShippingInfo().getShippingServiceCost()) ?
                        Currency.getInstance(itemType.getShippingInfo().getShippingServiceCost().getCurrencyId()) :
                        currency;
                Double shippingCost = !Objects.isNull(itemType.getShippingInfo().getShippingServiceCost()) ?
                        Double.parseDouble(Float.toString(itemType.getShippingInfo().getShippingServiceCost().getValue())) :
                        0.0;

                Double localPrice = price * currencyRestRepository.getExchangeRate(currency, this.localCurrency) +
                        shippingCost * currencyRestRepository.getExchangeRate(shippingCurrency, this.localCurrency);

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
                bookOffer.setLocalPriceWithShipment(round(localPrice, LOCAL_PRICE_DECIMAL_PLACES));

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
                if(!Objects.isNull(item.getVolumeInfo().getImageLinks())) {
                    bookOffer.setThumbnailUrl(item.getVolumeInfo().getImageLinks().getThumbnail());
                }
                bookOffer.setIsbn(
                        item.getVolumeInfo().getIndustryIdentifiers().
                                stream().
                                filter(x -> x.getType().equals(BooksSearchService.REQUIRED_GOOGLE_TYPE))
                                .findFirst()
                                .get()
                                .getIdentifier()
                );
                bookOffer.setLocalCurrency(this.localCurrency);
                bookOffer.setBuyUrl(item.getVolumeInfo().getInfoLink());

                if (item.getSaleInfo().getRetailPrice() != null) {
                    Currency currency = Currency.getInstance(item.getSaleInfo().getRetailPrice().getCurrencyCode());
                    Double price = item.getSaleInfo().getRetailPrice().getAmount();

                    bookOffer.setCurrency(currency);
                    bookOffer.setPrice(price);
                    bookOffer.setShippingCurrency(currency);
                    bookOffer.setShippingCost(NO_SHIPPING_COST);//In google books there are only e-books to buy
                    bookOffer.setForSale(true);

                    Double localPrice = price * currencyRestRepository.getExchangeRate(currency, this.localCurrency);

                    bookOffer.setLocalPriceWithShipment(round(localPrice, LOCAL_PRICE_DECIMAL_PLACES));
                } else {
                    bookOffer.setForSale(false);
                }

                bookOffers.add(bookOffer);
            }
        }

        return bookOffers;
    }

    private static double round(double value, int places) {
        Preconditions.checkArgument(places > MIN_DECIMAL_PLACES);

        return BigDecimal.valueOf(value)
                .setScale(places, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }
}
