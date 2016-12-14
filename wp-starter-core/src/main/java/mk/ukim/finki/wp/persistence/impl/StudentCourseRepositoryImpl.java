package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.StudentCourseAssociation;
import mk.ukim.finki.wp.persistence.StudentCourseRepository;
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
 * Created by Nacev on 14.12.2016.
 */
@Repository
public class StudentCourseRepositoryImpl implements StudentCourseRepository{

    @PersistenceContext(name = "wp")
    EntityManager entityManager;

    public List<StudentCourseAssociation> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentCourseAssociation> cq = cb.createQuery(StudentCourseAssociation.class);
        Root<StudentCourseAssociation> from = cq.from(StudentCourseAssociation.class);
        cq.select(from);
        TypedQuery<StudentCourseAssociation> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public StudentCourseAssociation findById(Integer id) {
        String queryStr =
                "SELECT sc from StudentCourseAssociation sc Where id='"+id+"'";
        TypedQuery<StudentCourseAssociation> query =
                entityManager.createQuery(queryStr, StudentCourseAssociation.class);
        StudentCourseAssociation result = query.getSingleResult();
        return result;
    }

    @Transactional
    public void save(StudentCourseAssociation entity) {
        /*Integer id=new Random().nextInt();
        group.setId(id);*/
        entityManager.persist(entity);
        entityManager.flush();

    }

    @Transactional
    public void update(Integer id, StudentCourseAssociation entity) {
     /*   Query query = entityManager.createQuery(
                "UPDATE Group g SET g.id='"+entity.getId()+"', g.name='"+entity.getName()+"', g.capacity='"+entity.getCapacity()+"', g.groupSize='"+entity.getGroupSize()+"'");
        int updateCount = query.executeUpdate();*/
        entityManager.merge(entity);
        entityManager.flush();
    }

    @Transactional
    public void delete(Integer id) {
        Query query = entityManager.createQuery(
                "DELETE FROM StudentCourseAssociation sc Where id='"+id+"'");
        int deletedCount = query.executeUpdate();
    }
}
