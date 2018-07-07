
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for sellingStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sellingStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentPrice" type="{http://www.ebay.com/marketplace/search/v1/services}currentPriceType"/>
 *         &lt;element name="convertedCurrentPrice" type="{http://www.ebay.com/marketplace/search/v1/services}convertedCurrentPriceType"/>
 *         &lt;element name="sellingState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeLeft" type="{http://www.w3.org/2001/XMLSchema}duration"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sellingStatusType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "currentPrice",
    "convertedCurrentPrice",
    "sellingState",
    "timeLeft"
})
public class SellingStatusType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected CurrentPriceType currentPrice;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected ConvertedCurrentPriceType convertedCurrentPrice;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String sellingState;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected Duration timeLeft;

    /**
     * Gets the value of the currentPrice property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentPriceType }
     *     
     */
    public CurrentPriceType getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Sets the value of the currentPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentPriceType }
     *     
     */
    public void setCurrentPrice(CurrentPriceType value) {
        this.currentPrice = value;
    }

    /**
     * Gets the value of the convertedCurrentPrice property.
     * 
     * @return
     *     possible object is
     *     {@link ConvertedCurrentPriceType }
     *     
     */
    public ConvertedCurrentPriceType getConvertedCurrentPrice() {
        return convertedCurrentPrice;
    }

    /**
     * Sets the value of the convertedCurrentPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConvertedCurrentPriceType }
     *     
     */
    public void setConvertedCurrentPrice(ConvertedCurrentPriceType value) {
        this.convertedCurrentPrice = value;
    }

    /**
     * Gets the value of the sellingState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellingState() {
        return sellingState;
    }

    /**
     * Sets the value of the sellingState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellingState(String value) {
        this.sellingState = value;
    }

    /**
     * Gets the value of the timeLeft property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTimeLeft() {
        return timeLeft;
    }

    /**
     * Sets the value of the timeLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTimeLeft(Duration value) {
        this.timeLeft = value;
    }

}
