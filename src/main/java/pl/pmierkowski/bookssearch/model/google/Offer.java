
package pl.pmierkowski.bookssearch.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {

    @Expose
    private Long finskyOfferType;
    @Expose
    private ListPrice listPrice;
    @Expose
    private RetailPrice retailPrice;

    public Long getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(Long finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }

}
