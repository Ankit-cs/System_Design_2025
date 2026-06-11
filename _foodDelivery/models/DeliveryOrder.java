package models;

public class DeliveryOrder extends Order{
    private String usersAddress;

    public DeliveryOrder(){
        usersAdress="";
    }

    public void setAddress(String add){
        usersAddress=add;
    }

    public String getUsersAddress(){
        return usersAddress;
    }
    
    @Override
    public String getType(){
        return "Delivery";
    }
}