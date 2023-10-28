
package webservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InvalidParametersException", targetNamespace = "http://webservices/")
public class InvalidParametersException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InvalidParametersException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public InvalidParametersException_Exception(String message, InvalidParametersException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public InvalidParametersException_Exception(String message, InvalidParametersException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: webservices.InvalidParametersException
     */
    public InvalidParametersException getFaultInfo() {
        return faultInfo;
    }

}
