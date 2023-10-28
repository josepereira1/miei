
package wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for game complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="game">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="users" type="{http://wsdl/}userSetCollection" minOccurs="0"/>
 *         &lt;element name="platforms" type="{http://wsdl/}platformSetCollection" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "game", propOrder = {
    "users",
    "platforms",
    "description",
    "name",
    "price",
    "year"
})
public class Game {

    protected UserSetCollection users;
    protected PlatformSetCollection platforms;
    protected String description;
    protected String name;
    protected double price;
    protected int year;

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link UserSetCollection }
     *     
     */
    public UserSetCollection getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserSetCollection }
     *     
     */
    public void setUsers(UserSetCollection value) {
        this.users = value;
    }

    /**
     * Gets the value of the platforms property.
     * 
     * @return
     *     possible object is
     *     {@link PlatformSetCollection }
     *     
     */
    public PlatformSetCollection getPlatforms() {
        return platforms;
    }

    /**
     * Sets the value of the platforms property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlatformSetCollection }
     *     
     */
    public void setPlatforms(PlatformSetCollection value) {
        this.platforms = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

}
