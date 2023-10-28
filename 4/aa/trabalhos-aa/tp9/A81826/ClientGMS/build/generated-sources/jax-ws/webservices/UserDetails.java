
package webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserDetails", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserDetails {


    /**
     * 
     * @param token
     * @return
     *     returns webservices.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchuser", targetNamespace = "http://webservices/", className = "webservices.Searchuser")
    @ResponseWrapper(localName = "searchuserResponse", targetNamespace = "http://webservices/", className = "webservices.SearchuserResponse")
    public User searchuser(
        @WebParam(name = "token", targetNamespace = "")
        String token);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.String
     * @throws PersistentException_Exception
     * @throws UserDontExistException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://webservices/", className = "webservices.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://webservices/", className = "webservices.LoginResponse")
    public String login(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password)
        throws PersistentException_Exception, UserDontExistException_Exception
    ;

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://webservices/", className = "webservices.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://webservices/", className = "webservices.HelloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
