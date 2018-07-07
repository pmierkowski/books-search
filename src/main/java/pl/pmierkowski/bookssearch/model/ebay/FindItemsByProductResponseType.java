
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for findItemsByProductResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findItemsByProductResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ack" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="searchResult" type="{http://www.ebay.com/marketplace/search/v1/services}searchResultType"/>
 *         &lt;element name="paginationOutput" type="{http://www.ebay.com/marketplace/search/v1/services}paginationOutputType"/>
 *         &lt;element name="itemSearchURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findItemsByProductResponseType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "ack",
    "version",
    "timestamp",
    "searchResult",
    "paginationOutput",
    "itemSearchURL"
})
public class FindItemsByProductResponseType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String ack;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String version;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected SearchResultType searchResult;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected PaginationOutputType paginationOutput;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String itemSearchURL;

    /**
     * Gets the value of the ack property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAck() {
        return ack;
    }

    /**
     * Sets the value of the ack property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAck(String value) {
        this.ack = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the searchResult property.
     * 
     * @return
     *     possible object is
     *     {@link SearchResultType }
     *     
     */
    public SearchResultType getSearchResult() {
        return searchResult;
    }

    /**
     * Sets the value of the searchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchResultType }
     *     
     */
    public void setSearchResult(SearchResultType value) {
        this.searchResult = value;
    }

    /**
     * Gets the value of the paginationOutput property.
     * 
     * @return
     *     possible object is
     *     {@link PaginationOutputType }
     *     
     */
    public PaginationOutputType getPaginationOutput() {
        return paginationOutput;
    }

    /**
     * Sets the value of the paginationOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaginationOutputType }
     *     
     */
    public void setPaginationOutput(PaginationOutputType value) {
        this.paginationOutput = value;
    }

    /**
     * Gets the value of the itemSearchURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemSearchURL() {
        return itemSearchURL;
    }

    /**
     * Sets the value of the itemSearchURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemSearchURL(String value) {
        this.itemSearchURL = value;
    }

}
