package models;

import java.util.List;
import strategies.PaymentStrategy;

public abstract class Order{
    private static int nextOrderId=0;
    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> items;
    protected PaymentStrategy paymentStrategy;
    protected String scheduled;
    protected double totalCost;

    public Order(){
        this.orderId=nextOrderId++;
        this.user=null;
        this.restaurant=null;
        this.items=null;
        this.paymentStrategy=null;
        this.scheduled="";
        this.totalCost=0;
    }

    public boolean processPayment(){
        if(paymentStrategy!=null){
            return paymentStrategy.pay(totalCost);
        } else {
            System.out.println("Please choose a payment mode first");
            return false;
        }
    }

    public abstract String getType();

    public void setUser(User u){ user=u; }
    public void setRestaurant(Restaurant r){ restaurant=r; }
    public void setItems(List<MenuItem> its){
        items=its;
        totalCost=0;
        if(items!=null){
            for(MenuItem i:items){
                totalCost+=i.getPrice();
            }
        }
    }
    public void setScheduled(String s){ scheduled=s; }
    public void setTotal(double t){ totalCost=t; }
    public void setPaymentStrategy(PaymentStrategy ps){ paymentStrategy=ps; }

    public int getOrderId(){ return orderId; }
    public User getUser(){ return user; }
    public Restaurant getRestaurant(){ return restaurant; }
    public List<MenuItem> getItems(){ return items; }
    public String getScheduled(){ return scheduled; }
    public double getTotal(){ return totalCost; }
}