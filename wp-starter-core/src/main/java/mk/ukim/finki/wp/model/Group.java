package mk.ukim.finki.wp.model;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Nacev on 28.11.2016.
 */
public class Group {
    private Long id;
    private String name;
    private Integer capacity;

    public Group(Long id, String name, Integer capacity){
        this.id=id;
        this.capacity=capacity;
        this.name=name;
    }

    public Long getId(){return id;}
}
