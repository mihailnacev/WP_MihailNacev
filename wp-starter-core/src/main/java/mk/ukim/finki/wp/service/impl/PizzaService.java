package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.service.IPizzaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nacev on 21.11.2016.
 */
@Service
public class PizzaService implements IPizzaService{
    public List<String> getPizzaTypes(){
        List<String> list=new ArrayList<String>();
        list.add("Small");
        list.add("Medium");
        list.add("Large");
        return list;
    }
}
