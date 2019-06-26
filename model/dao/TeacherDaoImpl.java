package HomeWork9.model.dao;

import HomeWork9.model.ConnectDB.ConnectDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public void insert(Teacher teacher) {
        Session session = ConnectDB.getSession();
        session.save(teacher);
        session.getTransaction();
        session.close();
    }

    @Override
    public void delete(String teacheCode) {
        Session session = ConnectDB.getSession();

        System.out.println(session.isOpen());
        Transaction transaction = session.beginTransaction();
        if (find(teacheCode) != null) {
            try {
                session.createQuery("delete from Teacher where teacherCode=" + teacheCode).executeUpdate();
                transaction.commit();

            } catch (Throwable t) {
                transaction.rollback();

                System.out.println("Can not Delete Teacher ");
                throw t;
            }finally {
                session.close();
            }
        }


    }

    @Override
    public void update(String teacherCode, Teacher teacher) {
        Session session1 = ConnectDB.getSession();
        Transaction transaction = session1.beginTransaction();
        Teacher th = find(teacherCode);
        if (th != null) {
            try {
                session1.createQuery("update Teacher set firstName = '" + teacher.getFirstName() + "', lastName =  '" + teacher.getLastName() + "' , salary =" + teacher.getSalary() + " , birthDay= '" + teacher.getBirthDay() + "'  where teacherCode= " + teacherCode).executeUpdate();
                transaction.commit();

            } catch (Throwable t) {
                transaction.rollback();
                System.out.println("Can not Update Teacher " + th);
                throw t;
            }finally {
                session1.close();
            }

        }

    }

    @Override
    public Teacher find(String... args) {
        Session session = ConnectDB.getSession();

        Teacher th = null;
        if (args.length == 1) {
            th = (Teacher) session.createQuery("select th from Teacher th where th.teacherCode=" + args[0]).getSingleResult();
            System.out.println(th);
            session.close();
            return th;
        } else if (args.length == 2) {
            th = (Teacher) session.createQuery("select th from Teacher th where firstName='" + args[0] + "' and lastName = '" + args[1] + "'").getSingleResult();
            session.close();
            return th;
        }
        System.out.println("Not Found Teacher (return null)");
        session.close();
        return th;
    }


    //if arg[0] & arg[1] != "" out like first name and like last name execute
    // if arg[0] !="" and arg[1] ==""  out like first name execute
    //if arg[0] =="" and arg[1] !=""  out like last name execute
    //else out  all Teacher

    @Override
    public List<Teacher> findAll(String... args) {
        Session session = ConnectDB.getSession();

        List<Teacher> teacherList = new ArrayList<>();


        if (!args[0].equals("") && !args[1].equals("")) {
            teacherList = session.createQuery("from Teacher th where th.firstName like '" + args[0] + "%' and th.lastName like '" + args[1] + "%'").list();
            System.out.println(teacherList);
            session.close();
            return teacherList;
        } else if (!args[0].equals("")) {
            teacherList = session.createQuery("from Teacher where firstName like '" + args[0] + "%'").list();
            System.out.println(teacherList);
            session.close();
            return teacherList;

        } else if (!args[1].equals("")) {
            teacherList = session.createQuery("from Teacher where lastName like '" + args[1] + "%'").list();
            System.out.println(teacherList);
            session.close();
            return teacherList;

        } else {
            teacherList = session.createQuery("from Teacher ").list();
            System.out.println(teacherList);
            session.close();
            return teacherList;
        }
    }

    public List<Teacher> listTh(Teacher teacher){
        Session session= ConnectDB.getSession();
        List<Teacher> teacherList = new ArrayList<>();


        teacherList=session.createQuery("from  Teacher  th where th.teacherCode='"+teacher.getTeacherCode()+"' and firstName  like '"+teacher.getFirstName()+"%'" +
                " and lastName like '"+teacher.getLastName()+"%' and (String)salary like '"+teacher.getSalary()+"%' and birthDay like '"+teacher.getBirthDay()+"%'").list();

        return teacherList;
    }

    @Override
    public List<Teacher> maxminsalary() {
        Session session = ConnectDB.getSession();
        List<Teacher> t=new ArrayList<>();
        t=  session.createQuery("from Teacher t where t.salary = (select max(s.salary) from Teacher s) or t.salary = (select min(s.salary) from Teacher s)").getResultList();
        System.out.println(t);
        return t;


    }

    @Override
    public List<Teacher> youngoldbirthday() {
        Session session = ConnectDB.getSession();
        List<Teacher> t=new ArrayList<>();
        t=  session.createQuery("from Teacher where birthDay = (select max(birthDay) from Teacher) or birthDay = (select min (birthDay) from Teacher)").getResultList();
        System.out.println(t);
        return t;

    }


}
