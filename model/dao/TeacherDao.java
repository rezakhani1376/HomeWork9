package HomeWork9.model.dao;

import java.util.List;

public interface TeacherDao {
    public void insert(Teacher teacher);

    public void delete(String teacheCode);

    public void update(String teacherCode, Teacher teacher);

    public Teacher find(String... args);

    public List<Teacher> findAll(String... args);

    public List<Teacher> listTh(Teacher teacher);

    public List<Teacher> maxminsalary();

    public List<Teacher> youngoldbirthday();


}