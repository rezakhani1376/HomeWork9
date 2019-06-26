package HomeWork9.model.dao;

import java.util.List;

public interface StudentDao {

    public void insert(Student student);
    public void delete(String StudentId);
    public void update(String id,Student student);
    public Student find(String... args);
    public List<Student> findAll(String... args);

}