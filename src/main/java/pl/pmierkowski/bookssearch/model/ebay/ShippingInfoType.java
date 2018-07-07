
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shippingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shippingInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shippingServiceCost" type="{http://www.ebay.com/marketplace/search/v1/services}shippingServiceCostType"/>
 *         &lt;element name="shippingType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shipToLocations" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expeditedShipping" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oneDayShippingAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="handlingTime" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shippingInfoType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "shippingServiceCost",
    "shippingType",
    "shipToLocations",
    "expeditedShipping",
    "oneDayShippingAvailable",
    "handlingTime"
})
public class ShippingInfoType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected ShippingServiceCostType shippingServiceCost;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String shippingType;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String shipToLocations;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String expeditedShipping;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String oneDayShippingAvailable;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected byte handlingTime;

    /**
     * Gets the value of the shippingServiceCost property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingServiceCostType }
     *     
     */
    public ShippingServiceCostType getShippingServiceCost() {
        return shippingServiceCost;
    }

    /**
     * Sets the value of the shippingServiceCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingServiceCostType }
     *     
     */
    public void setShippingServiceCost(ShippingServiceCostType value) {
        this.shippingServiceCost = value;
    }

    /**
     * Gets the value of the shippingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingType() {
        return shippingType;
    }

    /**
     * Sets the value of the shippingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingType(String value) {
        this.shippingType = value;
    }

    /**
     * Gets the value of the shipToLocations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipToLocations() {
        return shipToLocations;
    }

    /**
     * Sets the value of the shipToLocations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipToLocations(String value) {
        this.shipToLocations = value;
    }

    /**
     * Gets the value of the expeditedShipping property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpeditedShipping() {
        return expeditedShipping;
    }

    /**
     * Sets the value of the expeditedShipping property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpeditedShipping(String value) {
        this.expeditedShipping = value;
    }

    /**
     * Gets the value of the oneDayShippingAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOneDayShippingAvailable() {
        return oneDayShippingAvailable;
    }

    /**
     * Sets the value of the oneDayShippingAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOneDayShippingAvailable(String value) {
        this.oneDayShippingAvailable = value;
    }

    /**
     * Gets the value of the handlingTime property.
     * 
     */
    public byte getHandlingTime() {
        return handlingTime;
    }

    /**
     * Sets the value of the handlingTime property.
     * 
     */
    public void setHandlingTime(byte value) {
        this.handlingTime = value;
    }

}
