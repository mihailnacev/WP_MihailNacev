package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.StudentRepository;
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
 * Created by Nacev on 13.12.2016.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @PersistenceContext(name = "wp")
    EntityManager entityManager;

    public List<Student> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> from = cq.from(Student.class);
        cq.select(from);
        TypedQuery<Student> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public Student findById(String index) {
        String queryStr =
                "SELECT s from Student s Where index='"+index+"'";
        TypedQuery<Student> query =
                entityManager.createQuery(queryStr, Student.class);
        Student result = query.getSingleResult();
        return result;
    }

    @Transactional
    public void save(Student entity) {
        Student student=entity;
        /*Integer id=new Random().nextInt();
        group.setId(id);*/
        entityManager.persist(student);

    }

    @Transactional
    public void update(String index, Student entity) {
     /*   Query query = entityManager.createQuery(
                "UPDATE Group g SET g.id='"+entity.getId()+"', g.name='"+entity.getName()+"', g.capacity='"+entity.getCapacity()+"', g.groupSize='"+entity.getGroupSize()+"'");
        int updateCount = query.executeUpdate();*/
       entityManager.merge(entity);
    }

    @Transactional
    public void delete(String index) {
        Query query = entityManager.createQuery(
                "DELETE FROM Student s Where index='"+index+"'");
        int deletedCount = query.executeUpdate();
    }
}
