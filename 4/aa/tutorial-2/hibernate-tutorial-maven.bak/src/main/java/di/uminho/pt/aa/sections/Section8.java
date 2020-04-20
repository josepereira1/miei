package di.uminho.pt.aa.sections;

import di.uminho.pt.aa.business.Game;
import di.uminho.pt.aa.business.GameExistsException;
import di.uminho.pt.aa.business.Platform;
import di.uminho.pt.aa.business.PlatformExistsException;
import di.uminho.pt.aa.data.Data;
import di.uminho.pt.aa.data.FacadeData;

public class Section8 {
    public static void main(String[] args) {
        FacadeData data = new FacadeData();

        Platform platform = new Platform();
        platform.setName("PS4");
        platform.setYear(2014);
        platform.setDescription("description");
        platform.setManufacture("manufacture");

        try {
            data.addPlatform(platform);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }

        Game game = new Game();
        game.setName("CSGO");
        game.setPrice(20);
        game.setYear(2010);
        game.setDescription("description");
        game.setPlatform(platform);

        try {
            data.addGame(game);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }
    }
}
