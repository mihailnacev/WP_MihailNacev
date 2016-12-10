package mk.ukim.finki.wp.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Random;

/**
 * Created by Nacev on 28.11.2016.
 */
@Entity
@Table(name="lab_groups")
public class Group{

    public static class FIELDS {
        public static String ID = "id";
        public static String NAME = "name";
        public static String GROUP_SIZE = "groupSize";
        public static String COURSE = "course";

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @Min(value = 0)
    private Integer capacity;
    private Integer groupSize;

    public Group(){}
    public Group(Integer id, String name, Integer groupSize, Integer capacity){
        this.id=id;
        this.capacity=capacity;
        this.name=name;
        this.groupSize=groupSize;
    }

    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public Integer getCapacity(){return capacity;}
    public void setCapacity(Integer capacity){this.capacity=capacity;}
    public Integer getGroupSize(){return groupSize;}
    public void setGroupSize(Integer groupSize){this.groupSize=groupSize;}

}
