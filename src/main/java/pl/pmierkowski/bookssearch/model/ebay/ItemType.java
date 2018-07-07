
package pl.pmierkowski.bookssearch.model.ebay;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="globalId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primaryCategory" type="{http://www.ebay.com/marketplace/search/v1/services}primaryCategoryType"/>
 *         &lt;element name="galleryURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="viewItemURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="productId" type="{http://www.ebay.com/marketplace/search/v1/services}productIdType" minOccurs="0"/>
 *         &lt;element name="paymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="autoPay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shippingInfo" type="{http://www.ebay.com/marketplace/search/v1/services}shippingInfoType"/>
 *         &lt;element name="sellingStatus" type="{http://www.ebay.com/marketplace/search/v1/services}sellingStatusType"/>
 *         &lt;element name="listingInfo" type="{http://www.ebay.com/marketplace/search/v1/services}listingInfoType"/>
 *         &lt;element name="returnsAccepted" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="condition" type="{http://www.ebay.com/marketplace/search/v1/services}conditionType"/>
 *         &lt;element name="isMultiVariationListing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="discountPriceInfo" type="{http://www.ebay.com/marketplace/search/v1/services}discountPriceInfoType" minOccurs="0"/>
 *         &lt;element name="topRatedListing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "itemId",
    "title",
    "globalId",
    "subtitle",
    "primaryCategory",
    "galleryURL",
    "viewItemURL",
    "productId",
    "paymentMethod",
    "autoPay",
    "postalCode",
    "location",
    "country",
    "shippingInfo",
    "sellingStatus",
    "listingInfo",
    "returnsAccepted",
    "condition",
    "isMultiVariationListing",
    "discountPriceInfo",
    "topRatedListing"
})
public class ItemType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected long itemId;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String title;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String globalId;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected String subtitle;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected PrimaryCategoryType primaryCategory;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    @XmlSchemaType(name = "anyURI")
    protected String galleryURL;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String viewItemURL;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected ProductIdType productId;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected List<String> paymentMethod;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String autoPay;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected Integer postalCode;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String location;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String country;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected ShippingInfoType shippingInfo;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected SellingStatusType sellingStatus;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected ListingInfoType listingInfo;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String returnsAccepted;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected ConditionType condition;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String isMultiVariationListing;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected DiscountPriceInfoType discountPriceInfo;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String topRatedListing;

    /**
     * Gets the value of the itemId property.
     * 
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     */
    public void setItemId(long value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the globalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalId() {
        return globalId;
    }

    /**
     * Sets the value of the globalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalId(String value) {
        this.globalId = value;
    }

    /**
     * Gets the value of the subtitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Sets the value of the subtitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtitle(String value) {
        this.subtitle = value;
    }

    /**
     * Gets the value of the primaryCategory property.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryCategoryType }
     *     
     */
    public PrimaryCategoryType getPrimaryCategory() {
        return primaryCategory;
    }

    /**
     * Sets the value of the primaryCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryCategoryType }
     *     
     */
    public void setPrimaryCategory(PrimaryCategoryType value) {
        this.primaryCategory = value;
    }

    /**
     * Gets the value of the galleryURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGalleryURL() {
        return galleryURL;
    }

    /**
     * Sets the value of the galleryURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGalleryURL(String value) {
        this.galleryURL = value;
    }

    /**
     * Gets the value of the viewItemURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewItemURL() {
        return viewItemURL;
    }

    /**
     * Sets the value of the viewItemURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewItemURL(String value) {
        this.viewItemURL = value;
    }

    /**
     * Gets the value of the productId property.
     * 
     * @return
     *     possible object is
     *     {@link ProductIdType }
     *     
     */
    public ProductIdType getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductIdType }
     *     
     */
    public void setProductId(ProductIdType value) {
        this.productId = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMethod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPaymentMethod() {
        if (paymentMethod == null) {
            paymentMethod = new ArrayList<String>();
        }
        return this.paymentMethod;
    }

    /**
     * Gets the value of the autoPay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoPay() {
        return autoPay;
    }

    /**
     * Sets the value of the autoPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoPay(String value) {
        this.autoPay = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPostalCode(Integer value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the shippingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingInfoType }
     *     
     */
    public ShippingInfoType getShippingInfo() {
        return shippingInfo;
    }

    /**
     * Sets the value of the shippingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingInfoType }
     *     
     */
    public void setShippingInfo(ShippingInfoType value) {
        this.shippingInfo = value;
    }

    /**
     * Gets the value of the sellingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SellingStatusType }
     *     
     */
    public SellingStatusType getSellingStatus() {
        return sellingStatus;
    }

    /**
     * Sets the value of the sellingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellingStatusType }
     *     
     */
    public void setSellingStatus(SellingStatusType value) {
        this.sellingStatus = value;
    }

    /**
     * Gets the value of the listingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ListingInfoType }
     *     
     */
    public ListingInfoType getListingInfo() {
        return listingInfo;
    }

    /**
     * Sets the value of the listingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListingInfoType }
     *     
     */
    public void setListingInfo(ListingInfoType value) {
        this.listingInfo = value;
    }

    /**
     * Gets the value of the returnsAccepted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnsAccepted() {
        return returnsAccepted;
    }

    /**
     * Sets the value of the returnsAccepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnsAccepted(String value) {
        this.returnsAccepted = value;
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionType }
     *     
     */
    public ConditionType getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionType }
     *     
     */
    public void setCondition(ConditionType value) {
        this.condition = value;
    }

    /**
     * Gets the value of the isMultiVariationListing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsMultiVariationListing() {
        return isMultiVariationListing;
    }

    /**
     * Sets the value of the isMultiVariationListing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMultiVariationListing(String value) {
        this.isMultiVariationListing = value;
    }

    /**
     * Gets the value of the discountPriceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DiscountPriceInfoType }
     *     
     */
    public DiscountPriceInfoType getDiscountPriceInfo() {
        return discountPriceInfo;
    }

    /**
     * Sets the value of the discountPriceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscountPriceInfoType }
     *     
     */
    public void setDiscountPriceInfo(DiscountPriceInfoType value) {
        this.discountPriceInfo = value;
    }

    /**
     * Gets the value of the topRatedListing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopRatedListing() {
        return topRatedListing;
    }

    /**
     * Sets the value of the topRatedListing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopRatedListing(String value) {
        this.topRatedListing = value;
    }

}
