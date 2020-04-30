package pt.uminho.di.aa;

import org.orm.PersistentException;

public class GMS {
    public static void registerUser(User user) throws PersistentException {
        UserDAO.save(user);
    }

    public static void registerGame(Game game) throws PersistentException {
        GameDAO.save(game);
    }

    public static void registerPlatform(Platform platform) throws PersistentException {
        PlatformDAO.save(platform);
    }

    public static GameSetCollection listUserGames(String username) throws PersistentException {
        User user =  UserDAO.getUserByORMID(username);
        return user.games;
    }

    public static Game[] listAllGames() throws PersistentException {
        return GameDAO.listGameByCriteria(new GameCriteria());
    }

    public static Game searchGame(String name) throws PersistentException {
        return GameDAO.getGameByORMID(name);
    }

    public static boolean deleteGame(Game game) throws PersistentException {
        return GameDAO.delete(game);
    }
}
