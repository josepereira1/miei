package di.uminho.pt.aa.data;

import di.uminho.pt.aa.business.*;
import org.hibernate.Query;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

public class DAOGame {
    private Data data;

    public DAOGame(Data data){
        this.data = data;
    }

    public void addObject(Game game) throws GameExistsException {
        Query q = data.createQuery("FROM Game where name='" + game.getName()+"'");
        if(q!=null && q.list().size() == 0) {
            data.getSession().save(game);
            Transaction t = data.getSession().beginTransaction();
            try {
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.err.println("Unable to commit changes");
            }
        }else{
            throw new GameExistsException(game.getName());
        }
    }

    public Object getObject(int index){
        return data.getSession().get(Game.class, index);
    }

    public Collection<Game> getAllGames(){
        return (data.createQuery("FROM Game").list());
    }

    public Game getGameByName(String name){
        return (Game) data.createQuery("FROM Game WHERE name='" + name + "'").list().get(0);
    }

    public void deleteGameByName(String name){
        Query q1 = data.createQuery("FROM Game WHERE name='" + name + "'");
        Game game = (Game) q1.list().get(0);

        game.setPlatform(null);

        Query q2 = data.createQuery("FROM User");
        List<User> users = q2.list();

        for(User u : users){
            u.getGames().remove(game);
        }

        data.deleteObject(game);
    }
}
