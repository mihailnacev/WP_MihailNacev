package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.GroupRepository;
import mk.ukim.finki.wp.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nacev on 13.12.2016.
 */
@Service
@EnableJpaRepositories
public class StudentService{
    private static Map<String,Student> idToGroup = new HashMap<String, Student>();

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {

        return studentRepository.findAll();
        //return new ArrayList<Group>(idToGroup.values());
    }

    public Student findById(String index)
    {
        return studentRepository.findById(index);
        //return idToGroup.get(id);
    }

    public void save(Student entity) {
        /*Integer id=new Random().nextInt();
        entity.setId(id);*/
        studentRepository.save(entity);
        //idToGroup.put(id,entity);
    }

    public void update(String index, Student entity) {
        // idToGroup.remove(id);
        // idToGroup.put(id,entity);
        studentRepository.update(index,entity);
    }

    public void delete(String index) {
        studentRepository.delete(index);
        //idToGroup.remove(id);
    }
}
