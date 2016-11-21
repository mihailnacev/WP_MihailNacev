package mk.ukim.finki.wp.model;


/**
 * Created by Nacev on 20.11.2016.
 */
public class Order {
    private String pizzaType;
    private String clientName;
    private String clientAddress;
    private long orderId;

    public Order(String pizzaType,String clientName,String clientAddress){
        this.pizzaType=pizzaType;
        this.clientName=clientName;
        this.clientAddress=clientAddress;
    }

    public void setOrderId(long orderId){this.orderId=orderId;}
    public long getOrderId(){return orderId;}

    public void setPizzaType(String pizzaType){this.pizzaType=pizzaType;}
    public String getPizzaType(){return pizzaType;}

    public void setClientName(String clientName){this.clientName=clientName;}
    public String getClientName(){return clientName;}

    public void setClientAddress(String clientAddress){this.clientAddress=clientAddress;}
    public String getClientAddress(){return  clientAddress;}

}
