package pt.uminho.di.aa;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;

public class Main {
    public static void main(String[] args) {

        //  3 - REGISTAR UMA PLATFORM

        Platform platform = new Platform();
        platform.setName("PC");
        platform.setDescription("Computer");
        platform.setManufacture("PC Lda.");
        platform.setYear(2000);

        try {
            GMS.registerPlatform(platform);
        } catch (PersistentException e) {
            //e.printStackTrace();
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }

        //  2 - REGISTAR UM GAME

        Game game = new Game();
        game.setName("GTA V");
        game.setPlatform(platform);
        game.setDescription("Descrição do GTA V");
        game.setPrice(15);
        game.setYear(2012);

        try {
            GMS.registerGame(game);
        } catch (PersistentException e) {
            //e.printStackTrace();
        } catch (GameExistsException e) {
            e.printStackTrace();
        }

        //  1 - REGISTAR UM USER

        User user = new User();
        user.setName("José Pereira");
        user.setEmail("josepereira@gmail.com");
        user.setPassword("password");
        //user.games.add(game);

        try {
            GMS.registerUser(user);
        } catch (PersistentException e) {
            //e.printStackTrace();
        } catch (UserExistsException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*System.out.println("----------------------------------------");
        System.out.println("REQUISITO: 4");
        System.out.println("----------------------------------------");

        //  4 - LIST USER GAMES

        try {
            GameSetCollection games = GMS.listUserGames("José Pereira");
            if(games != null)for(Game g : games.toArray())System.out.println(g);
        } catch (PersistentException e) {
            //e.printStackTrace();
        }

        // -------------------------------------------
        //  ADICIONAR ALGUNS JOGOS

        Game g1 = new Game();
        g1.setName("CSGO");
        g1.setPlatform(platform);
        g1.setDescription("Descrição do jogo");
        g1.setYear(2012);
        g1.setPrice(22);

        try {
            GMS.registerGame(g1);
        } catch (PersistentException e) {
            //e.printStackTrace();
        } catch (GameExistsException e) {
            e.printStackTrace();
        }

        Game g2 = new Game();
        g2.setName("COD");
        g2.setPlatform(platform);
        g2.setDescription("Descrição do jogo");
        g2.setYear(2012);
        g2.setPrice(22);

        try {
            GMS.registerGame(g2);
        } catch (PersistentException e) {
            //e.printStackTrace();
        } catch (GameExistsException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------");
        System.out.println("REQUISITO: 5");
        System.out.println("----------------------------------------");
        // ----------------------------------------

        //  5 - LIST ALL GAMES

        try {
            Game[] games = GMS.listAllGames();

            for(Game g : games)System.out.println(g);

        } catch (PersistentException e) {
            //e.printStackTrace();
        }

        System.out.println("----------------------------------------");
        System.out.println("REQUISITO: 6");
        System.out.println("----------------------------------------");
        //  6 - SEARCH PELO JOGO GTA V

        Game res = null;

        try {
            res = GMS.searchGame("CSGO");
            System.out.println(res);
        } catch (PersistentException e) {
            //e.printStackTrace();
        } catch (GameNotExistsException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------");
        System.out.println("REQUISITO: 7");
        System.out.println("----------------------------------------");
        //  7 - DELETE GAME
        //  apenas para jogos associados a users
        try {
            System.out.println(GMS.deleteGame(res));
        } catch (PersistentException e) {
            //e.printStackTrace();
        } catch (GameNotExistsException e) {
            e.printStackTrace();
        }*/
    }
}
