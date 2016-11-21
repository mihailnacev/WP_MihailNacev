package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Nacev on 21.11.2016.
 */
@Service
public class OrderService implements IOrderService {
    public Order placeOrder(String pizzaType, String clientName, String address) {
        Order o=new Order(pizzaType,clientName,address);
        Random r=new Random();
        o.setOrderId(r.nextInt(100));
        return o;
    }
}
