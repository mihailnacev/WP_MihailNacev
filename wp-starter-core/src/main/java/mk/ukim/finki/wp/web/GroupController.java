package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nacev on 28.11.2016.
 */
@RestController
@RequestMapping(value = "/api/groups", produces = "application/json")
public class GroupController {
    @Autowired
    GroupService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Group> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Group findById(@PathVariable Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Group group){
        service.update(id,group);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}