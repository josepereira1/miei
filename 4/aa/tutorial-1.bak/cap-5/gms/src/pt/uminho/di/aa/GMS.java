package pt.uminho.di.aa;

import org.orm.PersistentException;

public class GMS {
    public static void registerUser(User user) throws PersistentException, UserExistsException {
        if(!containsUser(user.getName())) UserDAO.getUserByORMID(user.getName());
        else throw new UserExistsException(user.getName());
    }

    public static void registerGame(Game game) throws PersistentException, GameExistsException {
        if(!containsGame(game.getName()))GameDAO.save(game);
        else throw new GameExistsException(game.getName());
    }

    public static void registerPlatform(Platform platform) throws PersistentException, PlatformExistsException {
        if(!containsPlatform(platform.getName())) PlatformDAO.save(platform);
        else throw new PlatformExistsException(platform.getName());
    }

    public static GameSetCollection listUserGames(String username) throws PersistentException {
        if(containsUser(username)){
            User user =  UserDAO.getUserByORMID(username);
            return user.games;
        }
        return null;
    }

    public static Game[] listAllGames() throws PersistentException {
        return GameDAO.listGameByCriteria(new GameCriteria());
    }

    public static Game searchGame(String name) throws PersistentException {
        if(containsGame(name)) return GameDAO.getGameByORMID(name); else return null;
    }

    public static boolean deleteGame(Game game) throws PersistentException {
        if(containsGame(game.getName())) {
            return GameDAO.delete(game);
        }
        else return false;
    }

    private static boolean containsUser(String name) throws PersistentException {
        User res = UserDAO.getUserByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private static boolean containsGame(String name) throws PersistentException {
        Game res = GameDAO.getGameByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private static boolean containsPlatform(String name) throws PersistentException {
        Platform res = PlatformDAO.getPlatformByORMID(name);
        if(res == null) return false;
        else return true;
    }
}
