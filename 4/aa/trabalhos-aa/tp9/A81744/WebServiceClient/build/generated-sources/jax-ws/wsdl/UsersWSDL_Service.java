
package wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UsersWSDL", targetNamespace = "http://wsdl/", wsdlLocation = "http://localhost:8080/GMSWeb/UsersWSDL?wsdl")
public class UsersWSDL_Service
    extends Service
{

    private final static URL USERSWSDL_WSDL_LOCATION;
    private final static WebServiceException USERSWSDL_EXCEPTION;
    private final static QName USERSWSDL_QNAME = new QName("http://wsdl/", "UsersWSDL");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/GMSWeb/UsersWSDL?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERSWSDL_WSDL_LOCATION = url;
        USERSWSDL_EXCEPTION = e;
    }

    public UsersWSDL_Service() {
        super(__getWsdlLocation(), USERSWSDL_QNAME);
    }

    public UsersWSDL_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERSWSDL_QNAME, features);
    }

    public UsersWSDL_Service(URL wsdlLocation) {
        super(wsdlLocation, USERSWSDL_QNAME);
    }

    public UsersWSDL_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERSWSDL_QNAME, features);
    }

    public UsersWSDL_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UsersWSDL_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UsersWSDL
     */
    @WebEndpoint(name = "UsersWSDLPort")
    public UsersWSDL getUsersWSDLPort() {
        return super.getPort(new QName("http://wsdl/", "UsersWSDLPort"), UsersWSDL.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UsersWSDL
     */
    @WebEndpoint(name = "UsersWSDLPort")
    public UsersWSDL getUsersWSDLPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wsdl/", "UsersWSDLPort"), UsersWSDL.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERSWSDL_EXCEPTION!= null) {
            throw USERSWSDL_EXCEPTION;
        }
        return USERSWSDL_WSDL_LOCATION;
    }

}
