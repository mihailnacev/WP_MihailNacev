package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.IGroupService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Nacev on 28.11.2016.
 */
@Service
public class GroupService implements IGroupService {
    private static Map<Integer,Group> idToGroup = new HashMap<Integer, Group>();

    public List<Group> findAll() {

        return new ArrayList<Group>(idToGroup.values());
    }

    public Group findById(Integer id) {
        return idToGroup.get(id);
    }

    public void save(Group entity) {
        Integer id=new Random().nextInt();
        entity.setId(id);
        idToGroup.put(id,entity);
    }

    public void update(Integer id, Group entity) {
        idToGroup.remove(id);
        idToGroup.put(id,entity);
    }

    public void delete(Integer id) {
        idToGroup.remove(id);
    }
}
