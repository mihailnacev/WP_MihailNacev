package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.StudentCourseAssociation;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Nacev on 14.12.2016.
 */
public interface StudentCourseRepository {
    List<StudentCourseAssociation> findAll();
    StudentCourseAssociation findById(Integer id);
    void save(StudentCourseAssociation entity);
    void update(Integer id, StudentCourseAssociation entity);
    void delete(Integer id);
}
