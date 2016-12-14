package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.StudentCourseAssociation;
import mk.ukim.finki.wp.service.impl.StudentCourseService;
import mk.ukim.finki.wp.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Nacev on 14.12.2016.
 */
@RestController
@RequestMapping(value = "/api/studentscourses", produces = "application/json")
public class StudentCourseController {
    @Autowired
    StudentCourseService service;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<StudentCourseAssociation> findAll(){
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody StudentCourseAssociation studentCourseAssociation){
        service.save(studentCourseAssociation);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public StudentCourseAssociation findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody StudentCourseAssociation studentCourseAssociation){
        service.update(id,studentCourseAssociation);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
