package di.uminho.pt.aa.data;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//  Nesta classe definiu-se o código comum a todos os DAO, para evitar o uso de hierarquia, fiz por composição
public class Data {
    private Configuration configuration;
    private StandardServiceRegistry sr;
    private SessionFactory sf;
    private Session session;

    public Data(){
        configuration = new Configuration().configure();
        sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sf = configuration.buildSessionFactory(sr);

        session = sf.openSession();
        session.setFlushMode(FlushMode.COMMIT);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public StandardServiceRegistry getSr() {
        return sr;
    }

    public void setSr(StandardServiceRegistry sr) {
        this.sr = sr;
    }

    public SessionFactory getSf() {
        return sf;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Query createQuery(String query){
        return session.createQuery(query);
    }

    public void deleteObject(Object o){
        session.delete(o);
        Transaction t = session.beginTransaction();
        try {
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            System.err.println("Unable to commit changes");
        }
    }

    public void closeSession(){
        session.close();
        StandardServiceRegistryBuilder.destroy(sr);
    }
}
