
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

    private final static QName _ListResponse_QNAME = new QName("http://wsdl/", "listResponse");
    private final static QName _List_QNAME = new QName("http://wsdl/", "list");
    private final static QName _Search_QNAME = new QName("http://wsdl/", "search");
    private final static QName _PersistentException_QNAME = new QName("http://wsdl/", "PersistentException");
    private final static QName _SearchResponse_QNAME = new QName("http://wsdl/", "searchResponse");
    private final static QName _GameNotExistsException_QNAME = new QName("http://wsdl/", "GameNotExistsException");

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
     * Create an instance of {@link PersistentException }
     * 
     */
    public PersistentException createPersistentException() {
        return new PersistentException();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link GameNotExistsException }
     * 
     */
    public GameNotExistsException createGameNotExistsException() {
        return new GameNotExistsException();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link ListResponse }
     * 
     */
    public ListResponse createListResponse() {
        return new ListResponse();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link UserSetCollection }
     * 
     */
    public UserSetCollection createUserSetCollection() {
        return new UserSetCollection();
    }

    /**
     * Create an instance of {@link PlatformSetCollection }
     * 
     */
    public PlatformSetCollection createPlatformSetCollection() {
        return new PlatformSetCollection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "listResponse")
    public JAXBElement<ListResponse> createListResponse(ListResponse value) {
        return new JAXBElement<ListResponse>(_ListResponse_QNAME, ListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "list")
    public JAXBElement<List> createList(List value) {
        return new JAXBElement<List>(_List_QNAME, List.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GameNotExistsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdl/", name = "GameNotExistsException")
    public JAXBElement<GameNotExistsException> createGameNotExistsException(GameNotExistsException value) {
        return new JAXBElement<GameNotExistsException>(_GameNotExistsException_QNAME, GameNotExistsException.class, null, value);
    }

}
