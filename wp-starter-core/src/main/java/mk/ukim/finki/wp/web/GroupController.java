package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

/**
 * Created by Nacev on 28.11.2016.
 */
@RestController
@RequestMapping(value = "/api/groups", produces = "application/json")
public class GroupController {
    @Autowired
    GroupService service;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Group> findAll(){
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Group group){
       service.save(group);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Group findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Group group){
        service.update(id,group);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}