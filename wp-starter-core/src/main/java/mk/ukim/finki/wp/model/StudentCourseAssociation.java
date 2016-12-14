package mk.ukim.finki.wp.model;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Nacev on 14.12.2016.
 */
@Entity
@Table(name = "wp_student_course_association")
public class StudentCourseAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

    public StudentCourseAssociation(){}
    public StudentCourseAssociation(Integer id,Course course,Student student){
        this.id=id;
        this.course=course;
        this.student=student;
    }

    public Integer getId(){return id;}
    public Course getCourse(){return course;}
    public Student getStudent(){return student;}
    public void setId(Integer id){this.id=id;}
    public void setCourse(Course course){this.course=course;}
    public void setStudent(Student student){this.student=student;}
}
