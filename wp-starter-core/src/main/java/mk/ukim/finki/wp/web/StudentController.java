package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.service.impl.CourseService;
import mk.ukim.finki.wp.service.impl.GroupService;
import mk.ukim.finki.wp.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nacev on 13.12.2016.
 */
@RestController
@RequestMapping(value = "/api/students", produces = "application/json")
public class StudentController {
    @Autowired
    StudentService service;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Student> findAll(){
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Student student){
        service.save(student);
    }

    @RequestMapping(value = "/{index}",method = RequestMethod.GET)
    public Student findById(@PathVariable String index){
        return service.findById(index);
    }

    @RequestMapping(value = "/{index}",method = RequestMethod.PUT)
    public void update(@PathVariable String index, @RequestBody Student student){
        service.update(index,student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{index}")
    public void delete(@PathVariable String index){
        service.delete(index);
    }
}
