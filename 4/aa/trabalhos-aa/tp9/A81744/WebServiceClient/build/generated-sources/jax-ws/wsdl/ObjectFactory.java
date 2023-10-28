
package wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl package. 
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

    private final static QName _GenerateTokenResponse_QNAME = new QName("http://wsdl/", "generateTokenResponse");
    private final static QName _SearchWithToken_QNAME = new QName("http://wsdl/", "searchWithToken");
    private final static QName _Search_QNAME = new QName("http://wsdl/", "search");
    private final static QName _GenerateToken_QNAME = new QName("http://wsdl/", "generateToken");
    private final static QName _PersistentException_QNAME = new QName("http://wsdl/", "PersistentException");
    private final static QName _SearchResponse_QNAME = new QName("http://wsdl/", "searchResponse");
    private final static QName _SearchWithTokenResponse_QNAME = new QName("http://wsdl/", "searchWithTokenResponse");
    private final static QName _UserNotExistsException_QNAME = new QName("http://wsdl/", "UserNotExistsException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link GenerateToken }
     * 
     */
    public GenerateToken createGenerateToken() {
        return new GenerateToken();
    }

    /**
     * Create an instance of {@link PersistentException }
     * 
     */
    public PersistentException createPersistentException() {
        return new PersistentException();
    }

    /**
     * Create an instance of {@link UserNotExistsException }
     * 
     */
    public UserNotExistsException createUserNotExistsException() {
        return new UserNotExistsException();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link SearchWithTokenResponse }
     * 
     */
    public SearchWithTokenResponse createSearchWithTokenResponse() {
        return new SearchWithTokenResponse();
    }

    /**
     * Create an instance of {@link GenerateTokenResponse }
     * 
     */
    public GenerateTokenResponse createGenerateTokenResponse() {
        return new GenerateTokenResponse();
    }

    /**
     * Create an instance of {@link SearchWithToken }
     * 
     */
    public SearchWithToken createSearchWithToken() {
        return new SearchWithToken();
    }

    /**
     * Create an instance of {@link GameSetCollection }
     * 
     */
    public GameSetCollection createGameSetCollection() {
        return new GameSetCollection();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "generateTokenResponse")
    public JAXBElement<GenerateTokenResponse> createGenerateTokenResponse(GenerateTokenResponse value) {
        return new JAXBElement<GenerateTokenResponse>(_GenerateTokenResponse_QNAME, GenerateTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchWithToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "searchWithToken")
    public JAXBElement<SearchWithToken> createSearchWithToken(SearchWithToken value) {
        return new JAXBElement<SearchWithToken>(_SearchWithToken_QNAME, SearchWithToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "generateToken")
    public JAXBElement<GenerateToken> createGenerateToken(GenerateToken value) {
        return new JAXBElement<GenerateToken>(_GenerateToken_QNAME, GenerateToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "PersistentException")
    public JAXBElement<PersistentException> createPersistentException(PersistentException value) {
        return new JAXBElement<PersistentException>(_PersistentException_QNAME, PersistentException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchWithTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "searchWithTokenResponse")
    public JAXBElement<SearchWithTokenResponse> createSearchWithTokenResponse(SearchWithTokenResponse value) {
        return new JAXBElement<SearchWithTokenResponse>(_SearchWithTokenResponse_QNAME, SearchWithTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNotExistsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "UserNotExistsException")
    public JAXBElement<UserNotExistsException> createUserNotExistsException(UserNotExistsException value) {
        return new JAXBElement<UserNotExistsException>(_UserNotExistsException_QNAME, UserNotExistsException.class, null, value);
    }

}
