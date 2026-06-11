package models;

import java.util.ArrayList;
import java.util.List;

public class Cart{
    private Restaurant restaurant;
    private List<MenuItem> items=new ArrayList<>();

    public Cart(){
        restaurant=null;
    }
    public void addItems(MenuItem item){
        if(restaurant==null){
            System.out.println("Card:Set a restaurant before adding to a cart");
            return
        }
        items.add(item);
    }
    public double getTotalCost(){
        double ans=0;
        for(MenuItem it:items){
            ans+=it.getPrice();
        }
        return ans;
    }
    public boolean isEmpty(){
        return restaurant==null || items.isEmpty(); 
    }
    public void clear(){
        items.clear();
        restaurant=null;
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }
    public void setRestaurant(Restaurant res){
        restaurant=res;
    }
    public List<MenuItem> getItems(){
        return items;
    }

}