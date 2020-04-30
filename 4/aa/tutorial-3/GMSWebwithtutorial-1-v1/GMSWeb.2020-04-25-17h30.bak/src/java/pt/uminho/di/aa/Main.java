package pt.uminho.di.aa;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;

public class Main {
    public static void main(String[] args) {
        GMS gms = new GMS();
        
            /*Game[] games = null;
            try {
            games = gms.listAllGames(null);
            } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(Game g : games)System.out.println(g);
            */
        
        //  test login
        try {
            System.out.println(gms.login("joana", "password", null));
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
