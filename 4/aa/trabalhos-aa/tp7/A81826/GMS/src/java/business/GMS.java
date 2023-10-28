package business;

import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Arrays;
import java.util.Collection;

public class GMS {
    private static GMS gms;
    
    private GMS() {
        
    }
    
    public static GMS getGMS() {
        if(gms == null) gms = new GMS();
        return gms;
    }

    public static Collection<User> getAllUsers(PersistentSession s) throws PersistentException {
        if(s == null) return Arrays.asList(UserDAO.listUserByCriteria(new UserCriteria()));
        return Arrays.asList(UserDAO.listUserByCriteria(new UserCriteria(s)));
    }

    public static Collection<Game> allGames(PersistentSession s) throws PersistentException {
        if(s == null) return  Arrays.asList(GameDAO.listGameByCriteria(new GameCriteria()));
        return  Arrays.asList(GameDAO.listGameByCriteria(new GameCriteria(s)));
    }

    public static Collection<Platform> allPlatforms(PersistentSession s) throws PersistentException {
        if(s == null) return Arrays.asList(PlatformDAO.listPlatformByCriteria(new PlatformCriteria()));
        return Arrays.asList(PlatformDAO.listPlatformByCriteria(new PlatformCriteria(s)));
    }

    public static User getUserByName(String name, PersistentSession s) throws PersistentException, UserDontExistException {
        User u;
        if(s == null) u = UserDAO.getUserByORMID(name);
        else u = UserDAO.getUserByORMID(s,name);
        if(u == null) throw new UserDontExistException(name);
        return u;
    }

    public static Game getGameByName(String name, PersistentSession s) throws PersistentException, GameDontExistException {
        Game g;
        if(s == null) g = GameDAO.getGameByORMID(name);
        else g = GameDAO.getGameByORMID(s,name);
        if(g == null) throw new GameDontExistException(name);
        return g;
    }

    public static Platform getPlatformByName(String name, PersistentSession s) throws PersistentException, PlatformDontExistException {
        Platform p;
        if(s == null) p = PlatformDAO.getPlatformByORMID(name);
        else p = PlatformDAO.getPlatformByORMID(s,name);
        if(p == null) throw new PlatformDontExistException(name);
        return p;
    }

    public static Collection<Game> getGamesByUser(String name, PersistentSession s) throws UserDontExistException, PersistentException {
        User u;
        if(s ==  null) u = UserDAO.getUserByORMID(name);
        else u = UserDAO.getUserByORMID(s,name);
        if(u == null) throw new UserDontExistException(name);
        return Arrays.asList(u.games.toArray());
    }

    public static void registerUser(User user, PersistentSession s) throws UserAlreadyExistsException, PersistentException {
        User u;
        if(s == null) u = UserDAO.getUserByORMID(user.getName());
        else u = UserDAO.getUserByORMID(s,user.getName());
        if(u != null) throw new UserAlreadyExistsException(user.getName());
        UserDAO.save(user);
    }

    public static void registerGame(Game game, PersistentSession s) throws GameAlreadyExistsException, PersistentException {
        Game g;
        if(s == null) g = GameDAO.getGameByORMID(game.getName());
        else g = GameDAO.getGameByORMID(s,game.getName());
        if(g != null) throw new GameAlreadyExistsException(game.getName());
        GameDAO.save(game);
    }

    public static void registerPlatform(Platform platform, PersistentSession s) throws PlatformAlreadyExistsException, PersistentException {
        Platform p;
        if(s == null) p = PlatformDAO.getPlatformByORMID(platform.getName());
        else p = PlatformDAO.getPlatformByORMID(s,platform.getName());
        if(p != null) throw new PlatformAlreadyExistsException(platform.getName());
        PlatformDAO.save(platform);
    }

    public static void addGameToUser(String game, String user, PersistentSession s) throws GameDontExistException, PersistentException, UserDontExistException {
        Game g;
        User u;
        if(s == null) {
            g = GameDAO.getGameByORMID(game);
            u = UserDAO.getUserByORMID(user);
        }
        else {
            g = GameDAO.getGameByORMID(s,game);
            u = UserDAO.getUserByORMID(s,user);
        }
        if(g == null) throw new GameDontExistException(game);
        if(u == null) throw new UserDontExistException(user);
        u.games.add(g);
        UserDAO.save(u);
    }

    public static void deleteGame(String name, PersistentSession s) throws GameDontExistException, PersistentException {
        Game game;
        if(s == null) game = GameDAO.getGameByORMID(name);
        else game = GameDAO.getGameByORMID(s,name);
        if(game == null) throw new GameDontExistException(name);
        User[] users;
        if(s == null) users = UserDAO.listUserByCriteria(new UserCriteria());
        else users = UserDAO.listUserByCriteria(new UserCriteria(s));
        for (User user : users) {
            Game[] games = user.games.toArray();
            for (Game value : games) {
                if (value.equals(game)) {
                    user.games.remove(game);
                    break;
                }
            }
        }
        GameDAO.delete(game);
    }
}
