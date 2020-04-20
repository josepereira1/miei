package di.uminho.pt.aa.data;

import di.uminho.pt.aa.business.*;
import org.hibernate.Query;
import org.hibernate.persister.entity.Queryable;

import java.util.Collection;

public class FacadeData {
    DAOUser daoUser;
    DAOGame daoGame;
    DAOPlatform daoPlatform;
    DAOFormat daoFormat;
    Data data;

    public FacadeData(){
        data = new Data();
        daoUser = new DAOUser(data);
        daoGame = new DAOGame(data);
        daoPlatform = new DAOPlatform(data);
        daoFormat = new DAOFormat(data);
    }

    public void addUser(User user) throws UserExistsException {
        daoUser.addObject(user);
    }

    public User getUser(int index){
        return (User) daoUser.getObject(index);
    }

    public void addGame(Game game) throws GameExistsException {
        daoGame.addObject(game);
    }

    public Game getGame(int index){
        return (Game) daoGame.getObject(index);
    }

    public void addPlatform(Platform platform) throws PlatformExistsException {
        daoPlatform.addObject(platform);
    }

    public Platform getPlatform(int index){
        return (Platform) daoPlatform.getObject(index);
    }

    public Query createQuery(String query){
        return data.createQuery(query);
    }

    public void closeSession(){
        data.closeSession();
    }

    public User getUserByUsername(String username){
        return daoUser.getUserByUsername(username);
    }

    public Collection<Game> getAllGames(){
        return daoGame.getAllGames();
    }

    public Game getGameByName(String name){
        return daoGame.getGameByName(name);
    }

    public void addFormat(Format format) throws FormatExistsException {
        daoFormat.addObject(format);
    }

    public void deleteGameByName(String name){
        daoGame.deleteGameByName(name);
    }
}
