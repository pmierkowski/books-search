
package pl.pmierkowski.bookssearch.model.ebay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conditionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conditionId" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="conditionDisplayName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conditionType", namespace = "http://www.ebay.com/marketplace/search/v1/services", propOrder = {
    "conditionId",
    "conditionDisplayName"
})
public class ConditionType {

    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services")
    protected short conditionId;
    @XmlElement(namespace = "http://www.ebay.com/marketplace/search/v1/services", required = true)
    protected String conditionDisplayName;

    /**
     * Gets the value of the conditionId property.
     * 
     */
    public short getConditionId() {
        return conditionId;
    }

    /**
     * Sets the value of the conditionId property.
     * 
     */
    public void setConditionId(short value) {
        this.conditionId = value;
    }

    /**
     * Gets the value of the conditionDisplayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionDisplayName() {
        return conditionDisplayName;
    }

    /**
     * Sets the value of the conditionDisplayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionDisplayName(String value) {
        this.conditionDisplayName = value;
    }

}
