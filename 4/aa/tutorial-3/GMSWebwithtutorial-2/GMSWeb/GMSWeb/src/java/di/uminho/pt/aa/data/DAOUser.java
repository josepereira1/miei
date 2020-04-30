package di.uminho.pt.aa.data;

import di.uminho.pt.aa.business.*;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class DAOUser {
    private Data data;

    public DAOUser(Data data){
        this.data = data;
    }

    public void addObject(User user) throws UserExistsException {
        Query q = data.createQuery("FROM User where username='" + user.getUsername()+"'");
        if(q!=null && q.list().size() == 0) {
            data.getSession().merge(user);
            Transaction t = data.getSession().beginTransaction();
            try {
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.err.println("Unable to commit changes");
            }
        }else{
            throw new UserExistsException(user.getUsername());
        }
    }

    public Object getObject(int index){
        return data.getSession().get(User.class, index);
    }

    public User getUserByUsername(String username){
        return (User) createQuery("FROM User where username = '" + username + "'").list().get(0);
    }

    public Query createQuery(String query){
        return data.getSession().createQuery(query);
    }
}
