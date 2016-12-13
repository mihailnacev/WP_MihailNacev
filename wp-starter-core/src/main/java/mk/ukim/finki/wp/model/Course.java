package mk.ukim.finki.wp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by 141142 on 12/13/2016.
 */
@Entity
@Table(name="lab_courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    // sets the column name to the default value; optional annotation
    @JoinColumn(name = "course_id")
    public Course course;

    public Course(){}
    public Course(Integer id,String name,Course course){
        this.id=id;
        this.name=name;
        this.course=course;
    }

    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public Course getCourse(){return course;}
    public void setCourse(Course course){this.course=course;}

}
