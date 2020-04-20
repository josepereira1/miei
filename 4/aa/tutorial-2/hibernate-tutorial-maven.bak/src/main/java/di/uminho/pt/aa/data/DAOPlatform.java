package di.uminho.pt.aa.data;

import di.uminho.pt.aa.business.*;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class DAOPlatform {
    private Data data;

    public DAOPlatform(Data data){
        this.data = data;
    }

    public void addObject(Platform platform) throws PlatformExistsException{
        Query q = data.createQuery("FROM Platform where name='" + platform.getName()+"'");
        if(q!=null && q.list().size() == 0) {
            data.getSession().save(platform);
            Transaction t = data.getSession().beginTransaction();
            try {
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.err.println("Unable to commit changes");
            }
        }else{
            throw new PlatformExistsException(platform.getName());
        }
    }

    public Object getObject(int index){

        return data.getSession().get(Platform.class, index);
    }
}
