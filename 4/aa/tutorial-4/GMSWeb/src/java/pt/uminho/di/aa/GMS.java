package pt.uminho.di.aa;

import beans.GameBean;
import beans.GameBeanLocal;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GMS {

    private GameBeanLocal gameBean = lookupGameBeanLocal();
    
    private static GMS gms; //  Singleton
    private static PersistentSession session;
    
    
    
    protected GMS(){
        gameBean = (GameBean) lookupGameBeanLocal();
    }
    
    //  Singleton
    public static GMS getGMS(){
        if(gms == null)gms = new GMS();
        return gms;
    }
    
    public static PersistentSession getSession(){
        if(session == null){
            try {
                session = GamemanagementPersistentManager.instance().getSession();
            } catch (PersistentException ex) {
                Logger.getLogger(GMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return session;
    }
    
    public boolean login(String name, String password) throws PersistentException, NoSuchAlgorithmException {
        
        if(name != null && password !=null && containsUser(name)){
            String cryptPassword = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
            return cryptPassword.equals(UserDAO.getUserByORMID(name).getPassword());
        }else
            return false;
    }
    public void registerUser(User user) throws PersistentException, UserExistsException, NoSuchAlgorithmException, InvalidParametersException {
        if((user.getName() == null || user.getName().equals("")) || (user.getPassword() == null || user.getPassword().equals("")) || (user.getEmail() == null || user.getEmail().equals(""))) throw new InvalidParametersException();
        if(!containsUser(user.getName())){
            //  create user with an hashed password.
            if(user.getPassword() != null)user.setPassword(Checksum.getFileChecksum(user.getPassword().getBytes(), MessageDigest.getInstance("SHA-256")));
            UserDAO.save(user);
        }
        else throw new UserExistsException(user.getName());
    }

    public void registerGame(Game game) throws PersistentException, GameExistsException, InvalidParametersException {
        if(gameBean != null)
            gameBean.registerGame(game);
    }

    public void addGameToPersonalLibrary(String username, String gameName) throws PersistentException, UserNotExistsException, InvalidParametersException, GameNotExistsException {
        if(gameBean != null)gameBean.addGameToPersonalLibrary(username, gameName);
    }

    public void registerPlatform(Platform platform) throws PersistentException, PlatformExistsException {
        if(!containsPlatform(platform.getName())) PlatformDAO.save(platform);
        else throw new PlatformExistsException(platform.getName());
    }

    public GameSetCollection listUserGames(String username) throws PersistentException {
        if(gameBean != null)
            return gameBean.listUserGames(username);
        else return null;
    }

    public Game[] listAllGames() throws PersistentException {
        if(gameBean != null)
            return gameBean.listAllGames();
        else return null;
    }

    public Game searchGame(String name) throws PersistentException, GameNotExistsException, InvalidParametersException {
        if(gameBean != null)
            return gameBean.searchGame(name);
        else return null;
    }

    public boolean deleteGame(Game game) throws PersistentException, GameNotExistsException {
        if(gameBean != null)
            return gameBean.deleteGame(game);
        else return false;
    }

    private boolean containsUser(String name) throws PersistentException {
        User res = null;
        if(session != null)res = UserDAO.getUserByORMID(session, name);
        else res = UserDAO.getUserByORMID(name);
        if(res == null) return false;
        else return true;
    }
    
    private boolean containsPlatform(String name) throws PersistentException {
        Platform res = null;
        if(session != null)res = PlatformDAO.getPlatformByORMID(session, name);
        else res = PlatformDAO.getPlatformByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private GameBeanLocal lookupGameBeanLocal() {
        try {
            Context c = new InitialContext();
            return (GameBeanLocal) c.lookup("java:global/GMSWeb/GameBean!beans.GameBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
