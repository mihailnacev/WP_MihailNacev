package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Group;

import java.util.List;

/**
 * Created by Nacev on 10.12.2016.
 */
public interface GroupRepository {
    List<Group> findAll();
    Group findById(Integer id);
    void save(Group entity);
    void update(Integer id, Group entity);
    void delete(Integer id);
}
