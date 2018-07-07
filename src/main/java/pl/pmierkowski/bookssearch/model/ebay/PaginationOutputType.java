
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paginationOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paginationOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pageNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="entriesPerPage" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="totalPages" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="totalEntries" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paginationOutputType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "pageNumber",
    "entriesPerPage",
    "totalPages",
    "totalEntries"
})
public class PaginationOutputType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected byte pageNumber;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected byte entriesPerPage;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected byte totalPages;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected byte totalEntries;

    /**
     * Gets the value of the pageNumber property.
     * 
     */
    public byte getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the value of the pageNumber property.
     * 
     */
    public void setPageNumber(byte value) {
        this.pageNumber = value;
    }

    /**
     * Gets the value of the entriesPerPage property.
     * 
     */
    public byte getEntriesPerPage() {
        return entriesPerPage;
    }

    /**
     * Sets the value of the entriesPerPage property.
     * 
     */
    public void setEntriesPerPage(byte value) {
        this.entriesPerPage = value;
    }

    /**
     * Gets the value of the totalPages property.
     * 
     */
    public byte getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the value of the totalPages property.
     * 
     */
    public void setTotalPages(byte value) {
        this.totalPages = value;
    }

    /**
     * Gets the value of the totalEntries property.
     * 
     */
    public byte getTotalEntries() {
        return totalEntries;
    }

    /**
     * Sets the value of the totalEntries property.
     * 
     */
    public void setTotalEntries(byte value) {
        this.totalEntries = value;
    }

}
