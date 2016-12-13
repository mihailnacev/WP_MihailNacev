package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.service.impl.CourseService;
import mk.ukim.finki.wp.service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 141142 on 12/13/2016.
 */
@RestController
@RequestMapping(value = "/api/courses", produces = "application/json")
public class CourseController {
    @Autowired
    CourseService service;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Course> findAll(){
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Course course){
        service.save(course);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Course findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Course course){
        service.update(id,course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
