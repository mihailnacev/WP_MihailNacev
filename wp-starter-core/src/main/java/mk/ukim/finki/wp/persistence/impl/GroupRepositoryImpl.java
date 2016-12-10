package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

/**
 * Created by Nacev on 10.12.2016.
 */
@Repository
public class GroupRepositoryImpl implements GroupRepository{

    @PersistenceContext(name = "wp")
    EntityManager entityManager;

    public List<Group> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> cq = cb.createQuery(Group.class);
        Root<Group> from = cq.from(Group.class);
        cq.select(from);
        TypedQuery<Group> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public Group findById(Integer id) {
        String queryStr =
                "SELECT g from Group g Where id='"+id+"'";
        TypedQuery<Group> query =
                entityManager.createQuery(queryStr, Group.class);
        Group result = query.getSingleResult();
        return result;
    }

    @Transactional
    public void save(Group entity) {
        Group group=entity;
        /*Integer id=new Random().nextInt();
        group.setId(id);*/
        entityManager.persist(group);

    }

    @Transactional
    public void update(Integer id, Group entity) {
        Query query = entityManager.createQuery(
                "UPDATE Group g SET g.id='"+entity.getId()+"', g.name='"+entity.getName()+"', g.capacity='"+entity.getCapacity()+"', g.groupSize='"+entity.getGroupSize()+"'");
        int updateCount = query.executeUpdate();
    }

    @Transactional
    public void delete(Integer id) {
        Query query = entityManager.createQuery(
                "DELETE FROM Group g Where id='"+id+"'");
        int deletedCount = query.executeUpdate();
    }
}
