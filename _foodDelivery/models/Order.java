package models;

public class Order{
    private static int nextOrderId=0;
    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> items;
    protected PaymentStrategy paymentStrategy;
    protected String schduled;
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
        }
        else{
            System.out.println("Please choose a payment mode first");
            return false;
        }
    }
    public abstract String getType();

    public void setUser(User u){
        user=u;
    }
    public void setRestaurant(Restaurant r){
        restaurant=r;
    }
    public void setItems(List<MenuItem> its){
        items=its;
        totalCost=0;
        for(MenuItem i:items){
            totalCost+=i.getPrice();
        }
    }
    public void setScheduled(String s){
        scheduled=s;
    }
    public void setTotalCost(double t){
        totalCost=t;
    }
    public int getOrderId(){
        return orderId;
    }
    public User getUser(){
        return user;
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }
    public List<MenuItem> getItems(){
        return items;
    }
    public String getScheduled(){
        return scheduled;
    }
    public double getTotalCost(){
        return totalCost;
    }
    public void setPaymentStrategy(PaymentStrategy ps){
        paymentStrategy=ps;
    }
}