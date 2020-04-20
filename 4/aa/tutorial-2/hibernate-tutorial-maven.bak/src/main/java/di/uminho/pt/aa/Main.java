package di.uminho.pt.aa;

import di.uminho.pt.aa.business.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GMS gms = new GMS();

        ArrayList<Game> games = new ArrayList<>();
        ArrayList<Format> formats = new ArrayList<>();

        /*Format f1 = new Format();
        f1.setDescription("description");
        f1.setKind(1);

        formats.add(f1);*/

        Platform p1 = new Platform();
        p1.setName("PC");
        p1.setYear(2013);
        p1.setManufacture("PC");
        p1.setDescription("description");
        p1.setFormats(formats);

        /*try {
            gms.registarPlatform(p1);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }*/

        Game g1 = new Game();
        g1.setName("GTA IV");
        g1.setYear(2013);
        g1.setDescription("description");
        g1.setPrice(22);
        g1.setPlatform(p1);

        games.add(g1);

        try {
            gms.registarGame(g1);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }

        Game g2 = new Game();
        g2.setName("CSGO");
        g2.setYear(2013);
        g2.setDescription("description");
        g2.setPrice(22);
        g2.setPlatform(p1);

        games.add(g2);

        User u1 = new User();
        u1.setUsername("josepereira");
        u1.setPassword("password");
        u1.setGames(games);

        System.out.println("#REGISTER USER WITH SOME GAMES");

        try {
            gms.registerUser(u1);
        } catch (UserExistsException e) {
            e.printStackTrace();
        }

        Game g3 = new Game();
        g3.setName("LOL");
        g3.setYear(2013);
        g3.setDescription("description");
        g3.setPrice(22);
        g3.setPlatform(p1);

        System.out.println("#REGISTER GAME");

        try {
            gms.registarGame(g3);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }

        System.out.println("#REGISTER USER THAT ALREADY EXISTS, AND WE GET EXCEPTION (SAME TO GAME AND PLATFORM)");

        try {
            gms.registerUser(u1);
        } catch (UserExistsException e) {
            e.printStackTrace();
        }

        Platform p2 = new Platform();
        p2.setName("PC");
        p2.setYear(2013);
        p2.setManufacture("Microsoft");
        p2.setDescription("description");

        try {
            gms.registarPlatform(p2);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }

        System.out.println("#LIST GAMES OF USER");

        Collection<Game> res = gms.listUserGames("josepereira");
        for(Game g : res)System.out.println(g);

        System.out.println("#LIST ALL GAMES");

        for(Game g : gms.listAllGames())System.out.println(g);

        System.out.println("#SEARCH A GAME");

        System.out.println(gms.searchGame("LOL"));

        Scanner input = new Scanner(System.in);
        input.nextLine();

        gms.deleteGame("GTA IV");
    }
}