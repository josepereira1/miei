package di.uminho.pt.aa.data;

import di.uminho.pt.aa.business.*;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class DAOFormat {
    private Data data;

    public DAOFormat(Data data)
    {
        this.data = data;
    }

    public void addObject(Format format) throws FormatExistsException {
        Query q = data.createQuery("FROM Format where kind='" + format.getKind()+"'");
        if(q!=null && q.list().size() == 0) {
            data.getSession().merge(format);
            Transaction t = data.getSession().beginTransaction();
            try {
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.err.println("Unable to commit changes");
            }
        }else{
            throw new FormatExistsException(String.valueOf(format.getKind()));
        }
    }
}
