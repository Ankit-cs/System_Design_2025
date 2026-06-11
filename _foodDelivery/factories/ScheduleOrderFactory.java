package factories;

import java.util.List;
import models.*;
import strategies.PaymentStrategy;
import utils.TimeUtils;

public class ScheduleOrderFactory implements OrderFactory{
    private String scheduleTime;

    public ScheduleOrderFactory(String scheduleTime){
        this.scheduleTime=scheduleTime;
    }

   @Override
   public Order createOrder(User user,Cart cart,Restaurant restaurant,
    List<MenuItem> menuItems,PaymentStrategy paymentStrategy,double totalCost,String orderType){
    Order order=null;
    if(orderType.equalsIgnoreCase("Delivery")){
        DeliveryOrder deliveryOrder=new DeliveryOrder();
        deliveryOrder.setUserAddress(user.getAddress());
        order=deliveryOrder;
    } else {
      PickupOrder pickupOrder=new PickupOrder();
      pickupOrder.setRestaurantAddress(restaurant.getLocation());
      order=pickupOrder;
    }
   order.setUser(user);
   order.setRestaurant(restaurant);
   order.setItems(menuItems);
   order.setPaymentStrategy(paymentStrategy);
   order.setScheduled(this.scheduleTime != null ? this.scheduleTime : TimeUtils.getCurrentTime());
   order.setTotal(totalCost);
   return order;
    }
}