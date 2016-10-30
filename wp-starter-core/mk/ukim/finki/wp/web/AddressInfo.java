package mk.ukim.finki.wp.web;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nacev on 30.10.2016.
 */
@WebServlet(name = "AddressInfo")
public class AddressInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String os=java.lang.System.getProperty("os.name");
        request.getSession().setAttribute("os",os);
        String  browserDetails =request.getHeader("User-Agent");
        request.getSession().setAttribute("browserDetails",browserDetails);
        Object pizzaSize=request.getSession().getAttribute("pizzaSize");
        request.getSession().setAttribute("pizzaSize",pizzaSize);
        String address = request.getParameter("address");
        request.getSession().setAttribute("address", address);
        String name= request.getParameter("name");
        request.getSession().setAttribute("name", name);
        RequestDispatcher dispatcher=request.getRequestDispatcher("confirmation.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
