package di.uminho.pt.aa.sections;

import di.uminho.pt.aa.data.Data;
import di.uminho.pt.aa.business.Game;
import di.uminho.pt.aa.data.FacadeData;

public class Section6 {
    public static void main(String[] args) {
        //  SECTION 6
        try {
            /*
            //  1 - configuration: this loads the hibernate.cfg.xml configurations.
            org.hibernate.cfg.Configuration configuration = new Configuration().configure();
            StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            //  2 - session factory: this enables the possibility to create sessions.
            SessionFactory sf = configuration.buildSessionFactory(sr);  //  this code is deprecated
            //  SessionFactory sf  = new MetadataSources( sr ).getMetadataBuilder().build().getSessionFactoryBuilder().build();

            //  3 - session: the sessions allows to perform the persistency opera- tions.
            Session s = sf.openSession();
            s.setFlushMode(FlushMode.COMMIT);   //  propagate changes on commit

            //  4 - start transaction: the persistency operations should be performed inside a transaction.
            Transaction t = s.beginTransaction();

            //  create a new object

            Game g = new Game();
            g.setName("GTA V");
            g.setYear(2012);
            g.setPrice(20);
            g.setDescription("description");


            //  5 - save the object
            s.save(g);

            //  6 - commit the transaction
            try {
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.err.println("Unable to commit changes");
            }

            Game res = (Game) s.get(Game.class, 1);

            System.out.println(res);

            //  7 - close the session and end process
            s.close();
            StandardServiceRegistryBuilder.destroy(sr);
            */
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Unable to connect to hibernate");
        }

        //  ABAIXO ESTÁ O CÓDIGO MAIS ABSTRATO


        try {

            FacadeData data = new FacadeData();

            Game g = new Game();
            g.setName("GTA V");
            g.setYear(2012);
            g.setPrice(20);
            g.setDescription("description");

            data.addGame(g);

            Game res = (Game) data.getGame(0);

            System.out.println(res);

            data.closeSession();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Unable to connect to hibernate");
        }
    }
}
