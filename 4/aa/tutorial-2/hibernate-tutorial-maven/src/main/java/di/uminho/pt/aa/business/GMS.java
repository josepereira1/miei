package di.uminho.pt.aa.business;

import di.uminho.pt.aa.data.FacadeData;

import java.util.Collection;

public class GMS {
    private FacadeData data;

    public GMS(){
        this.data = new FacadeData();
    }

    public void registerUser(User user) throws UserExistsException {
        data.addUser(user);
    }

    public void registarGame(Game game) throws GameExistsException {
        data.addGame(game);
    }

    public void registarPlatform(Platform platform) throws PlatformExistsException {
        data.addPlatform(platform);
    }

    public Collection<Game> listUserGames(String username){
        return data.getUserByUsername(username).getGames();
    }

    public Collection<Game> listAllGames(){
        return data.getAllGames();
    }

    public Game searchGame(String name){
        return data.getGameByName(name);
    }

    public void deleteGame(String name){
        data.deleteGameByName(name);
    }
}
