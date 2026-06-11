package managers;

import java.util.ArrayList;
import java.util.List;
import models.Restaurant;

public class RestaurantManager{
    private List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager(){ }

    public static RestaurantManager getInstance(){
        if(instance==null){
            instance=new RestaurantManager();
        }
        return instance;
    }
    public void addRestaurant(Restaurant r){
        restaurants.add(r);
    }
    public List<Restaurant> searchByLocation(String loc){
        List<Restaurant> result=new ArrayList<>();
        if(loc==null) return result;
        String lower=loc.toLowerCase();
        for(Restaurant r:restaurants){
            String rl=r.getLocation().toLowerCase();
            if(rl.contains(lower)){
                result.add(r);
            }
        }
        return result;
    }
}
