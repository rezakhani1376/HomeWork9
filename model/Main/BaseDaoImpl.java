package HomeWork9.model.Main;

import HomeWork9.model.ConnectDB.ConnectDB;
import org.hibernate.Session;
import java.io.Serializable;
import java.util.List;
public class BaseDaoImpl<T extends Serializable> implements BaseDAO<T>{
    Session session = ConnectDB.getSession();
    @Override
    public void insert(T t) {
        session.save(t);
        session.getTransaction();
    }
    @Override
    public void delete(String Code) {
    }
    @Override
    public void update(String id, T t) {
    }
    @Override
    public T find(String... args) {
        T t = null;
        if (args.length == 1) {
            t = (T) session.createQuery("select st from T st where st.id=" + args[0]).getSingleResult();
            System.out.println(t);
            return t;
        } else if (args.length == 2) {
            t = (T) session.createQuery("select st from T st where firstName=" + args[0] + " and lastName =" + args[1]).getSingleResult();
            return t;
        }
        System.out.println("Not Found T (return null)");
        return t;
    }

    @Override
    public List findAll(String... args) {
        return null;
    }
}
