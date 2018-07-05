
package pl.pmierkowski.bookssearch.model.google;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleInfo {

    @Expose
    private String country;
    @Expose
    private Boolean isEbook;
    @Expose
    private String saleability;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getIsEbook() {
        return isEbook;
    }

    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

}
