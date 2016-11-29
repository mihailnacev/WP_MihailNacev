package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import java.util.Random;

/**
 * Created by Nacev on 28.11.2016.
 */
public class Group{
    private Integer id;
    private String name;
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
