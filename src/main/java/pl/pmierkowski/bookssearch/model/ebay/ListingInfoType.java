
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for listingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listingInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bestOfferEnabled" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="buyItNowAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="listingType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gift" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="watchCount" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listingInfoType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "bestOfferEnabled",
    "buyItNowAvailable",
    "startTime",
    "endTime",
    "listingType",
    "gift",
    "watchCount"
})
public class ListingInfoType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String bestOfferEnabled;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String buyItNowAvailable;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String listingType;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String gift;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected Byte watchCount;

    /**
     * Gets the value of the bestOfferEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBestOfferEnabled() {
        return bestOfferEnabled;
    }

    /**
     * Sets the value of the bestOfferEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBestOfferEnabled(String value) {
        this.bestOfferEnabled = value;
    }

    /**
     * Gets the value of the buyItNowAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyItNowAvailable() {
        return buyItNowAvailable;
    }

    /**
     * Sets the value of the buyItNowAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyItNowAvailable(String value) {
        this.buyItNowAvailable = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the listingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListingType() {
        return listingType;
    }

    /**
     * Sets the value of the listingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListingType(String value) {
        this.listingType = value;
    }

    /**
     * Gets the value of the gift property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGift() {
        return gift;
    }

    /**
     * Sets the value of the gift property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGift(String value) {
        this.gift = value;
    }

    /**
     * Gets the value of the watchCount property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWatchCount() {
        return watchCount;
    }

    /**
     * Sets the value of the watchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWatchCount(Byte value) {
        this.watchCount = value;
    }

}
