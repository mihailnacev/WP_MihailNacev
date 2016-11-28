package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.IGroupService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nacev on 28.11.2016.
 */
@Service
public class GroupService implements IGroupService {
    static Map<Long,Group> idToGroup;

    public List<Group> findAll() {
        List<Group> list=new ArrayList<Group>();
        Set<Long> keySet=idToGroup.keySet();
        for (Long key: keySet){
            list.add(idToGroup.get(key));
        }
        return list;
    }

    public Group findById(Long id) {
        return idToGroup.get(id);
    }

    public void save(Group entity) {
        idToGroup.put(entity.getId(),entity);
    }

    public void update(Long id, Group entity) {
        idToGroup.put(id,entity);
    }

    public void delete(Long id) {
        idToGroup.remove(id);
    }
}
