package pl.pmierkowski.bookssearch.model;

import java.util.Currency;

public class BookOffer {
    private Seller seller;
    private String title;
    private String subtitle;
    private String thumbnailUrl;
    private String isbn;
    private Currency currency;
    private Double price;
    private Double shippingCost;
    private Currency shippingCurrency;
    private String buyUrl;
    private boolean isForSale;
    private Currency localCurrency;
    private Double localPriceWithShipment;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Currency getShippingCurrency() {
        return shippingCurrency;
    }

    public void setShippingCurrency(Currency shippingCurrency) {
        this.shippingCurrency = shippingCurrency;
    }

    public String getBuyUrl() {
        return buyUrl;
    }

    public void setBuyUrl(String buyUrl) {
        this.buyUrl = buyUrl;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public Currency getLocalCurrency() {
        return localCurrency;
    }

    public void setLocalCurrency(Currency localCurrency) {
        this.localCurrency = localCurrency;
    }

    public Double getLocalPriceWithShipment() {
        return localPriceWithShipment;
    }

    public void setLocalPriceWithShipment(Double localPriceWithShipment) {
        this.localPriceWithShipment = localPriceWithShipment;
    }
}
