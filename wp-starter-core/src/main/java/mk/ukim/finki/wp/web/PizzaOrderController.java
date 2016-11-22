package mk.ukim.finki.wp.web;
import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.impl.OrderService;
import mk.ukim.finki.wp.service.impl.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by Nacev on 21.11.2016.
 */
@Controller
public class PizzaOrderController {
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index(){

        List<String> list=pizzaService.getPizzaTypes();
        return new ModelAndView("pizza_index",
                "list", list);
    }
    @RequestMapping(value = "/by_user/{id}")
    public ModelAndView showClientInfo(@PathVariable int id,@RequestParam String pizzaType, HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Cookie [] cookies=request.getCookies();
        boolean flag=false;
        Cookie k=null;
        if(cookies!=null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    flag = true;
                    k=c;
                    break;
                }
            }
        }
        if(flag){
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("DispatcherServlet");
            ServletRequest req=(ServletRequest) request;
            ServletResponse res=(ServletResponse) response;
            session.setAttribute("pizzaType", pizzaType);
            session.setAttribute("clientID", id);
            String value=k.getValue();
            String [] parts=value.split(" ");
            response.sendRedirect("/order?clientName="+parts[0]+"&"+"clientAddress="+parts[1]);

        }
        else {
            session.setAttribute("pizzaType", pizzaType);
            session.setAttribute("clientID", id);
        }
        return new ModelAndView("customer_info");
    }
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public ModelAndView placeOrder(@RequestParam String clientName, @RequestParam String clientAddress, HttpSession session,HttpServletResponse response){
       Order order=orderService.placeOrder((String) session.getAttribute("pizzaType"),clientName,clientAddress);
       session.setAttribute("order",order);
        Cookie k = new Cookie("user", String.format("%s %s",clientName,clientAddress));
        response.addCookie(k);
        return new ModelAndView("order");
    }

}
