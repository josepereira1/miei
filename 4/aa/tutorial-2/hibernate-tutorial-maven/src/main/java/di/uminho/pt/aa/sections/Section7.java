package di.uminho.pt.aa.sections;

import di.uminho.pt.aa.business.User;
import di.uminho.pt.aa.data.FacadeData;
import org.hibernate.Query;

import java.util.List;

public class Section7 {
    public static void main(String[] args) {
        try {
            FacadeData data = new FacadeData();

            User user1 = new User();
            user1.setUsername("josepereira1");
            user1.setPassword("password");

            User user2 = new User();
            user2.setUsername("josepereira2");
            user2.setPassword("password");

            data.addUser(user1);
            data.addUser(user2);

            Query q = data.createQuery("from User where id = (select max(id) from User)");
            List list = null;
            if(q !=null)
                list = q.list();
            System.out.println(list.get(0));

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Unable to connect to hibernate");
        }
    }
}
