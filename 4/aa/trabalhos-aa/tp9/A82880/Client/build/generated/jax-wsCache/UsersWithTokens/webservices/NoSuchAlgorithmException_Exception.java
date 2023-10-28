
package webservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NoSuchAlgorithmException", targetNamespace = "http://webservices/")
public class NoSuchAlgorithmException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NoSuchAlgorithmException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NoSuchAlgorithmException_Exception(String message, NoSuchAlgorithmException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NoSuchAlgorithmException_Exception(String message, NoSuchAlgorithmException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: webservices.NoSuchAlgorithmException
     */
    public NoSuchAlgorithmException getFaultInfo() {
        return faultInfo;
    }

}
