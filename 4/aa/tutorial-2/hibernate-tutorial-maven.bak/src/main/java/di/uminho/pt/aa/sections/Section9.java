package di.uminho.pt.aa.sections;

import di.uminho.pt.aa.business.*;
import di.uminho.pt.aa.data.Data;
import di.uminho.pt.aa.data.FacadeData;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class Section9 {
    public static void main(String[] args) {
        FacadeData data = new FacadeData();

        Platform platform = new Platform();
        platform.setName("PS4");
        platform.setYear(2017);
        platform.setDescription("description");
        platform.setManufacture("manufacture");

        try {
            data.addPlatform(platform);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }

        List<Game> games = new ArrayList<>();

        Game g1 = new Game();
        g1.setName("CSGO");
        g1.setPrice(20);
        g1.setYear(2017);
        g1.setDescription("description");
        g1.setPlatform(platform);

        try {
            data.addGame(g1);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }

        games.add(g1);

        Game g2 = new Game();
        g2.setName("LOL");
        g2.setPrice(20);
        g2.setYear(2017);
        g2.setDescription("description");
        g2.setPlatform(platform);

        try {
            data.addGame(g2);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }

        games.add(g2);

        User user = new User();
        user.setUsername("josepereira3");
        user.setPassword("password");
        user.setGames(games);

        try {
            data.addUser(user);
        } catch (UserExistsException e) {
            e.printStackTrace();
        }

        Query q = data.createQuery("from Game g, Platform p where g.platform = p and p.year = 2017");
    }
}
