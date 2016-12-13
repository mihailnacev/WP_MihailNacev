package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Group;

import java.util.List;

/**
 * Created by 141142 on 12/13/2016.
 */
public interface CourseRepository {
    List<Course> findAll();
    Course findById(Integer id);
    void save(Course entity);
    void update(Integer id, Course entity);
    void delete(Integer id);
}
