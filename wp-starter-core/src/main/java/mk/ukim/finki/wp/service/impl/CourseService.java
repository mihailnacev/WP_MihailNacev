package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.CourseRepository;
import mk.ukim.finki.wp.persistence.GroupRepository;
import mk.ukim.finki.wp.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 141142 on 12/13/2016.
 */
@Service
@EnableJpaRepositories
public class CourseService {
        private static Map<Integer,Course> idToGroup = new HashMap<Integer, Course>();

        @Autowired
        CourseRepository courseRepository;

        public List<Course> findAll() {

            return courseRepository.findAll();
            //return new ArrayList<Group>(idToGroup.values());
        }

        public Course findById(Integer id)
        {
            return courseRepository.findById(id);
            //return idToGroup.get(id);
        }

        public void save(Course entity) {
        /*Integer id=new Random().nextInt();
        entity.setId(id);*/
            courseRepository.save(entity);
            //idToGroup.put(id,entity);
        }

        public void update(Integer id, Course entity) {
            // idToGroup.remove(id);
            // idToGroup.put(id,entity);
            courseRepository.update(id,entity);
        }

        public void delete(Integer id) {
            courseRepository.delete(id);
            //idToGroup.remove(id);
        }
    }
