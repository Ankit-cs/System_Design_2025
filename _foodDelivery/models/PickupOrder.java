package models;

public class PickupOrder extends Order{
    private String restaurantAddress;
    public PickupOrder(){
        restaurantAddress="";
    }
    public void setRestaurantAddress(String address){
        restaurantAddress=address;
    }
    public String getRestaurantAddress(){
        return restaurantAddress;
    }
    @Override
    public String getType(){
        return "Pickup";
    }
}