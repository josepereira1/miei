package pt.uminho.di.aa;

import org.orm.PersistentException;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            GMS.addGameToPersonalLibrary("jose", "GTA V", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (UserNotExistsException e) {
            e.printStackTrace();
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (GameNotExistsException e) {
            e.printStackTrace();
        }

        GameSetCollection games = null;
        try {
            games = GMS.listUserGames("jose", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        Iterator it = games.getIterator();
        while(it.hasNext()){
            Game g = (Game) it.next();
            System.out.println(g);
        }
    }
}
