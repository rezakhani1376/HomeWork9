package HomeWork9.model.ConnectDB;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Teradata14Dialect;
import HomeWork9.model.dao.*;
public class ConnectDB {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        Session session=DbConnector.getSession();
//        StudentDAO st=new StudentDaoImpl();
//        Student student1=new Student("mohammadjavad","farahani");
//        Student student2=new Student("alireza","daei");
//        Student student3=new Student("amirmahdi","farahani");
//        st.insert(student1);
//        st.insert(student2);
//        st.insert(student3);
//        st.delete("8");
//        Student st1=st.find("9");
//        System.out.println(st1);
//        st.findAll("al","");
//            st.update("1",new Student("ali","rezaei"));


        TeacherDAO th=new TeacherDaoImpl();
//        Teacher th1=new Teacher("ali","farahani","130",1500000,"1983-04-02");
//        Teacher th4=new Teacher("reza","asgari","131",1200000,"1990-02-05");
//        Teacher th5=new Teacher("xaniar","farahani","134",1300000,"1998-07-07");
//        Teacher th2=new Teacher("raha","javid","127",2000000,"2000-11-10");
//        Teacher th3=new Teacher("davood","imani","129",5000000,"2018-01-11");
//        th.insert(th1);
//        th.insert(th4);
//        th.insert(th5);
//        th.insert(th2);
//        th.insert(th3);
//        Teacher thf=th.find("davood","imani");
//        System.out.println(thf);
//            th.findAll("ali","");
//            th.update("130",new Teacher("alireza","farahani","130",1400000,"1990-04-02"));
//        th.delete("130");
        /*try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }*/
    }
}
