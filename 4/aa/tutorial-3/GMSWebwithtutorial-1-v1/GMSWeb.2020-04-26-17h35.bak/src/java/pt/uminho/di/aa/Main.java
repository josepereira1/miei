package pt.uminho.di.aa;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;

public class Main {
    public static void main(String[] args) throws PersistentException, GameExistsException, UserNotExistsException {
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
        /*try {
            System.out.println(gms.login("joana", "password", null));
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GameSetCollection games = null;
        
        try {
            games = gms.listUserGames("Joana", null);
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game[] gamesArr = games.toArray();
        for(Game g : gamesArr){
            System.out.println(g);
        }*/
        
        /*Game g = new Game();
        g.setName("exemplo");
        g.setPrice(22);
        g.setYear(2020);
        g.setDescription("description");
        
        
        /*Platform p = PlatformDAO.getPlatformByORMID("PC");

        g.setPlatform(p);

        User user = UserDAO.getUserByORMID("Joana");

        user.games.add(g);

        UserDAO.save(user);*/
        
        //gms.registerGame("PC", "Joana", g, null);
    }
}
