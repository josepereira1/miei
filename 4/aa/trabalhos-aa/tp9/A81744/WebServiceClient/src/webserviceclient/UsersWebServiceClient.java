/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserviceclient;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import wsdl.*;

/**
 *
 * @author Ricardo Petronilho
 */
public class UsersWebServiceClient {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UsersWSDL usersWS = new UsersWSDL_Service().getUsersWSDLPort();
        
        // without token
        /*
        try {                    
            String rightPassword = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
            String wrongPassword = "abc";            
            User user = usersWS.search("ricardo", rightPassword);
            if (user == null) System.out.println("unauthorized");
            else System.out.println(user);
        } catch (PersistentException_Exception e) {
            e.printStackTrace();
            System.out.println("internal server error");
        } catch (UserNotExistsException_Exception e) {
            e.printStackTrace();
            System.out.println("user does not exist");
        }   
        */
        
        // with token
        try {                
            String username = "ricardo";
            String rightPassword = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
            String wrongPassword = "abc";            
            String token = usersWS.generateToken(username, rightPassword);
            if (token == null) {
                System.out.println("unauthorized");
                return;
            }
            else {
                User user = usersWS.searchWithToken(username, token);
                if (user == null) System.out.println("unauthorized");
                else System.out.println(user);
            }                      
            
        } catch (PersistentException_Exception e) {
            e.printStackTrace();
            System.out.println("internal server error");
        } catch (UserNotExistsException_Exception e) {
            e.printStackTrace();
            System.out.println("user does not exist");
        }      
    }
    
}
