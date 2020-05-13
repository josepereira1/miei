/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import beans.RemoteGameBeanRemote;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author josepereira
 */
public class Client {
    public static void main(String[] args){
        Hashtable<String, String> config = new Hashtable<>();
        config.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        config.put("org.omg.CORBA.ORBInitialHost","localhost");
        config.put("org.omg.CORBA.ORBInitialPort", "3700");
        Context context = null;
        try {
            context = new InitialContext(config);
        } catch (NamingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            RemoteGameBeanRemote remoteBean = (RemoteGameBeanRemote) context.lookup("java:global/GMSWeb/RemoteGameBean!bean.RemoteGameBeanRemote");
        } catch (NamingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
