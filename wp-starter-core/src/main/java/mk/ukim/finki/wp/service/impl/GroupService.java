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
    private static Map<Long,Group> idToGroup = new HashMap<Long, Group>();

    public List<Group> findAll() {

        return new ArrayList<Group>(idToGroup.values());
    }

    public Group findById(Long id) {
        return idToGroup.get(id);
    }

    public void save(Group entity) {
        Long id=new Random().nextLong();
        entity.setId(id);
        idToGroup.put(id,entity);
    }

    public void update(Long id, Group entity) {
        idToGroup.put(id,entity);
    }

    public void delete(Long id) {
        idToGroup.remove(id);
    }
}
