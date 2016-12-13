package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.model.Student;

import java.util.List;

/**
 * Created by Nacev on 13.12.2016.
 */
public interface StudentRepository {
    List<Student> findAll();
    Student findById(String index);
    void save(Student entity);
    void update(String index, Student entity);
    void delete(String index);
}
