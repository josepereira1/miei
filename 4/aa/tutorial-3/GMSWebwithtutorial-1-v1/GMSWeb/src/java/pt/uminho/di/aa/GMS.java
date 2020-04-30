package pt.uminho.di.aa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class GMS {
    public static boolean login(String name, String password, PersistentSession session) throws PersistentException, NoSuchAlgorithmException{
        if(name != null && password !=null && containsUser(name, session)){
            String cryptPassword = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
            return cryptPassword.equals(UserDAO.getUserByORMID(name).getPassword());
        }else
            return false;
    }
    public static void registerUser(User user, PersistentSession session) throws PersistentException, UserExistsException, NoSuchAlgorithmException, InvalidParametersException {
        if((user.getName() == null || user.getName().equals("")) || (user.getPassword() == null || user.getPassword().equals("")) || (user.getEmail() == null || user.getEmail().equals(""))) throw new InvalidParametersException();
        if(!containsUser(user.getName(), session)){
            //  create user with an hashed password.
            if(user.getPassword() != null)user.setPassword(Checksum.getFileChecksum(user.getPassword().getBytes(), MessageDigest.getInstance("SHA-256")));
            UserDAO.save(user);
        }
        else throw new UserExistsException(user.getName());
    }

    public static void registerGame(String platformName,String username, Game game, PersistentSession session) throws PersistentException, GameExistsException, UserNotExistsException, PlatformNotExistsException, InvalidParametersException {
        //  assumindo que no caso do meu programa ter uma relação de 1 user para N games, significa que os games tem de ser adicionados por cada utilizador 
        
        if(platformName == null || platformName.equals("") || username == null || username.equals("") || game.getName() == null || game.getName().equals("") || game.getPrice() < 1 || game.getYear() < 1950 || game.getDescription() == null || game.getDescription().equals("")) throw new InvalidParametersException();
        if(!containsUser(username, session)) throw new UserNotExistsException(username);
        if(!containsPlatform(platformName, session)) throw new PlatformNotExistsException(platformName);
                
        if(!containsGame(game.getName(), session)){
            Platform platform = null;
            
            if(session == null)platform = PlatformDAO.getPlatformByORMID(platformName);
            else platform = PlatformDAO.getPlatformByORMID(session, platformName);
            
            game.setPlatform(platform);
            User user = UserDAO.getUserByORMID(username);
            user.games.add(game);
            UserDAO.save(user);
        }
        else throw new GameExistsException(game.getName());
    }

    public static void registerPlatform(Platform platform, PersistentSession session) throws PersistentException, PlatformExistsException {
        if(!containsPlatform(platform.getName(), session)) PlatformDAO.save(platform);
        else throw new PlatformExistsException(platform.getName());
    }

    public static GameSetCollection listUserGames(String username, PersistentSession session) throws PersistentException {
        if(containsUser(username, session))
            if(session != null)
                return UserDAO.getUserByORMID(session, username).games;
            else return UserDAO.getUserByORMID(username).games;
        return null;
    }

    public static Game[] listAllGames(PersistentSession session) throws PersistentException {
        if(session != null)return GameDAO.listGameByCriteria(new GameCriteria(session));
        else return GameDAO.listGameByCriteria(new GameCriteria());
    }

    public static Game searchGame(String name, PersistentSession session) throws PersistentException, GameNotExistsException, InvalidParametersException {
        if(name == null || name.equals("")) throw new InvalidParametersException();
        if(containsGame(name, session))
            if(session != null) return GameDAO.getGameByORMID(session, name);
            else return GameDAO.getGameByORMID(name);
        else throw new GameNotExistsException(name);
    }

    public static boolean deleteGame(Game game, PersistentSession session) throws PersistentException, GameNotExistsException {
        if(containsGame(game.getName(), session)) return GameDAO.delete(game);
        else throw new GameNotExistsException(game.getName());
    }

    private static boolean containsUser(String name, PersistentSession session) throws PersistentException {
        User res = null;
        if(session != null)res = UserDAO.getUserByORMID(session, name);
        else res = UserDAO.getUserByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private static boolean containsGame(String name, PersistentSession session) throws PersistentException {
        Game res = null;
        if(session != null)res = GameDAO.getGameByORMID(session, name);
        else res = GameDAO.getGameByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private static boolean containsPlatform(String name, PersistentSession session) throws PersistentException {
        Platform res = null;
        if(session != null)res = PlatformDAO.getPlatformByORMID(session, name);
        else res = PlatformDAO.getPlatformByORMID(name);
        if(res == null) return false;
        else return true;
    }
}
