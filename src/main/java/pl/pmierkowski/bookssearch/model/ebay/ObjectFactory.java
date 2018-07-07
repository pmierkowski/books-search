
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.pmierkowski.bookssearch.model.ebay package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindItemsByProductResponse_QNAME = new QName("http://www.ebay.com/marketplace/search/v1/services", "findItemsByProductResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.pmierkowski.bookssearch.model.ebay
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindItemsByProductResponseType }
     * 
     */
    public FindItemsByProductResponseType createFindItemsByProductResponseType() {
        return new FindItemsByProductResponseType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link CurrentPriceType }
     * 
     */
    public CurrentPriceType createCurrentPriceType() {
        return new CurrentPriceType();
    }

    /**
     * Create an instance of {@link PrimaryCategoryType }
     * 
     */
    public PrimaryCategoryType createPrimaryCategoryType() {
        return new PrimaryCategoryType();
    }

    /**
     * Create an instance of {@link PaginationOutputType }
     * 
     */
    public PaginationOutputType createPaginationOutputType() {
        return new PaginationOutputType();
    }

    /**
     * Create an instance of {@link SearchResultType }
     * 
     */
    public SearchResultType createSearchResultType() {
        return new SearchResultType();
    }

    /**
     * Create an instance of {@link ShippingInfoType }
     * 
     */
    public ShippingInfoType createShippingInfoType() {
        return new ShippingInfoType();
    }

    /**
     * Create an instance of {@link ListingInfoType }
     * 
     */
    public ListingInfoType createListingInfoType() {
        return new ListingInfoType();
    }

    /**
     * Create an instance of {@link OriginalRetailPriceType }
     * 
     */
    public OriginalRetailPriceType createOriginalRetailPriceType() {
        return new OriginalRetailPriceType();
    }

    /**
     * Create an instance of {@link SellingStatusType }
     * 
     */
    public SellingStatusType createSellingStatusType() {
        return new SellingStatusType();
    }

    /**
     * Create an instance of {@link ProductIdType }
     * 
     */
    public ProductIdType createProductIdType() {
        return new ProductIdType();
    }

    /**
     * Create an instance of {@link DiscountPriceInfoType }
     * 
     */
    public DiscountPriceInfoType createDiscountPriceInfoType() {
        return new DiscountPriceInfoType();
    }

    /**
     * Create an instance of {@link ConditionType }
     * 
     */
    public ConditionType createConditionType() {
        return new ConditionType();
    }

    /**
     * Create an instance of {@link ConvertedCurrentPriceType }
     * 
     */
    public ConvertedCurrentPriceType createConvertedCurrentPriceType() {
        return new ConvertedCurrentPriceType();
    }

    /**
     * Create an instance of {@link ShippingServiceCostType }
     * 
     */
    public ShippingServiceCostType createShippingServiceCostType() {
        return new ShippingServiceCostType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindItemsByProductResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/search/v1/services", name = "findItemsByProductResponse")
    public JAXBElement<FindItemsByProductResponseType> createFindItemsByProductResponse(FindItemsByProductResponseType value) {
        return new JAXBElement<FindItemsByProductResponseType>(_FindItemsByProductResponse_QNAME, FindItemsByProductResponseType.class, null, value);
    }

}
