package factories;

import java.utils.List;
import models.*;
import strategies.*;


public class ScheduleOrderFactory implements OrderFactory{
    private String scheduleTime;
    
    private ScheduleOrderFactory(String scheduleTime){
        this.scheduleTime=scheduleTime;
    }

   @Override
   public Order createOrder(User user,Cart cart,Restaurant restaurant,
    List<MenuItem> menuItems,PaymentStrategy paymentStrategy,double totalCost,String orderType){
    Order order=null;
    if(orderType.equals("Delivery")){
    DeliveryOrder deliveryOrder=new DeliveryOrder();
    deliveryOrder.setUserAddress(user.getAddress());
    order=deliveryOrder;
   }
   else{
      PickupOrder pickupOrder=new PickupOrder();
      pickupOrder.setRestaurantAddress(restaurant.getLocation());
      order=pickupOrder;
   }
   order.setUser(user);
   order.setRestaurant(restaurant);
   order.setItems(menuItems);
   order.setPaymentStrategy(paymentStrategy);
   order.setSheduled(TimeUtils.getCurrentTime());
   order.setTotal(totalCost);
   return order;
    }
}