package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.StudentCourseAssociation;
import mk.ukim.finki.wp.persistence.StudentCourseRepository;
import mk.ukim.finki.wp.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nacev on 14.12.2016.
 */
@Service
@EnableJpaRepositories
public class StudentCourseService {
    private static Map<Integer,StudentCourseAssociation> idToGroup = new HashMap<Integer, StudentCourseAssociation>();

    @Autowired
    StudentCourseRepository studentCourseRepository;

    public List<StudentCourseAssociation> findAll() {

        return studentCourseRepository.findAll();
        //return new ArrayList<Group>(idToGroup.values());
    }

    public StudentCourseAssociation findById(Integer id)
    {
        return studentCourseRepository.findById(id);
        //return idToGroup.get(id);
    }

    public void save(StudentCourseAssociation entity) {
        /*Integer id=new Random().nextInt();
        entity.setId(id);*/
        studentCourseRepository.save(entity);
        //idToGroup.put(id,entity);
    }

    public void update(Integer id, StudentCourseAssociation entity) {
        // idToGroup.remove(id);
        // idToGroup.put(id,entity);
        studentCourseRepository.update(id,entity);
    }

    public void delete(Integer id) {
        studentCourseRepository.delete(id);
        //idToGroup.remove(id);
    }

}
