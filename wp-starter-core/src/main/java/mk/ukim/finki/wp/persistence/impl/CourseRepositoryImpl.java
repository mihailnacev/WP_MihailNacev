package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.CourseRepository;
import mk.ukim.finki.wp.persistence.GroupRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by 141142 on 12/13/2016.
 */
@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceContext(name = "wp")
    EntityManager entityManager;

    public List<Course> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> from = cq.from(Course.class);
        cq.select(from);
        TypedQuery<Course> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public Course findById(Integer id) {
        String queryStr =
                "SELECT c from Course c Where id='"+id+"'";
        TypedQuery<Course> query =
                entityManager.createQuery(queryStr, Course.class);
        Course result = query.getSingleResult();
        return result;
    }

    @Transactional
    public void save(Course entity) {
        Course course=entity;
        /*Integer id=new Random().nextInt();
        group.setId(id);*/
        entityManager.persist(course);
        entityManager.flush();

    }

    @Transactional
    public void update(Integer id, Course entity) {
     /*   Query query = entityManager.createQuery(
                "UPDATE Group g SET g.id='"+entity.getId()+"', g.name='"+entity.getName()+"', g.capacity='"+entity.getCapacity()+"', g.groupSize='"+entity.getGroupSize()+"'");
        int updateCount = query.executeUpdate();*/
        entityManager.merge(entity);
        entityManager.flush();
    }

    @Transactional
    public void delete(Integer id) {
        Query query = entityManager.createQuery(
                "DELETE FROM Course c Where id='"+id+"'");
        int deletedCount = query.executeUpdate();
    }
}
