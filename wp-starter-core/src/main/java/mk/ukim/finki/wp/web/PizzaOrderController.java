package mk.ukim.finki.wp.web;
import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.impl.OrderService;
import mk.ukim.finki.wp.service.impl.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by Nacev on 21.11.2016.
 */
@Controller
public class PizzaOrderController {
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        List<String> list=pizzaService.getPizzaTypes();
        return new ModelAndView("pizza_index",
                "list", list);
    }
    @RequestMapping(value = "/by_user/{id}")
    public ModelAndView showClientInfo(@PathVariable int id,@RequestParam String pizzaType, HttpSession session){
        session.setAttribute("pizzaType",pizzaType);
        session.setAttribute("clientID",id);
        return new ModelAndView("customer_info");
    }
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public ModelAndView placeOrder(@RequestParam String clientName, @RequestParam String clientAddress, HttpSession session){
       Order order=orderService.placeOrder((String) session.getAttribute("pizzaType"),clientName,clientAddress);
        session.setAttribute("order",order);
        return new ModelAndView("order");
    }

}
