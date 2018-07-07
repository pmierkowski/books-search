
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for discountPriceInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="discountPriceInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="originalRetailPrice" type="{http://www.ebay.com/marketplace/search/v1/services}originalRetailPriceType"/>
 *         &lt;element name="pricingTreatment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="soldOnEbay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="soldOffEbay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discountPriceInfoType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "originalRetailPrice",
    "pricingTreatment",
    "soldOnEbay",
    "soldOffEbay"
})
public class DiscountPriceInfoType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected OriginalRetailPriceType originalRetailPrice;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String pricingTreatment;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String soldOnEbay;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String soldOffEbay;

    /**
     * Gets the value of the originalRetailPrice property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalRetailPriceType }
     *     
     */
    public OriginalRetailPriceType getOriginalRetailPrice() {
        return originalRetailPrice;
    }

    /**
     * Sets the value of the originalRetailPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalRetailPriceType }
     *     
     */
    public void setOriginalRetailPrice(OriginalRetailPriceType value) {
        this.originalRetailPrice = value;
    }

    /**
     * Gets the value of the pricingTreatment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingTreatment() {
        return pricingTreatment;
    }

    /**
     * Sets the value of the pricingTreatment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingTreatment(String value) {
        this.pricingTreatment = value;
    }

    /**
     * Gets the value of the soldOnEbay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoldOnEbay() {
        return soldOnEbay;
    }

    /**
     * Sets the value of the soldOnEbay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoldOnEbay(String value) {
        this.soldOnEbay = value;
    }

    /**
     * Gets the value of the soldOffEbay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoldOffEbay() {
        return soldOffEbay;
    }

    /**
     * Sets the value of the soldOffEbay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoldOffEbay(String value) {
        this.soldOffEbay = value;
    }

}
