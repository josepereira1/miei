/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsdl;

import aa.GMS;
import aa.User;
import aa.UserNotExistsException;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@WebService(serviceName = "UsersWSDL")
public class UsersWSDL {
    
    private Map<String, String> tokens = new HashMap<>();

    // antes de existir o token (o username e password são enviados como parâmetros)
    @WebMethod(operationName = "search")
    public User search(@WebParam(name = "name") String username, @WebParam(name = "password") String password) throws PersistentException, UserNotExistsException {
        if (GMS.getGMS().autenticateUser(username, password) == false) return null;
        else return GMS.getGMS().getUser(username);
    }
    
    @WebMethod(operationName = "searchWithToken")
    public User searchWithToken(@WebParam(name = "name") String username, @WebParam(name = "token") String token) throws PersistentException, UserNotExistsException {      
        if (this.tokens.get(username) == null || this.tokens.get(username).equals(token) == false) return null;
        else return GMS.getGMS().getUser(username);
    }
    
    @WebMethod(operationName = "generateToken")
    public String generateToken(@WebParam(name = "name") String username, @WebParam(name = "password") String password) throws PersistentException, UserNotExistsException {
        if (GMS.getGMS().autenticateUser(username, password) == false) return null;
        else {
            String token = username + password;
            this.tokens.put(username, token);
            return token;
        }
    }
}
