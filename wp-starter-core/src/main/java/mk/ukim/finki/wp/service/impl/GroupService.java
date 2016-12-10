package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupRepository;
import mk.ukim.finki.wp.persistence.impl.GroupRepositoryImpl;
import mk.ukim.finki.wp.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Nacev on 28.11.2016.
 */
@Service
@EnableJpaRepositories
public class GroupService implements IGroupService {
    private static Map<Integer,Group> idToGroup = new HashMap<Integer, Group>();

    @Autowired
    GroupRepository groupRepository;

    public List<Group> findAll() {

        return groupRepository.findAll();
        //return new ArrayList<Group>(idToGroup.values());
    }

    public Group findById(Integer id)
    {
        return groupRepository.findById(id);
        //return idToGroup.get(id);
    }

    public void save(Group entity) {
        /*Integer id=new Random().nextInt();
        entity.setId(id);*/
        groupRepository.save(entity);
        //idToGroup.put(id,entity);
    }

    public void update(Integer id, Group entity) {
       // idToGroup.remove(id);
       // idToGroup.put(id,entity);
        groupRepository.update(id,entity);
    }

    public void delete(Integer id) {
        groupRepository.delete(id);
        //idToGroup.remove(id);
    }
}
