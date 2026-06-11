package factories;

import java.utils.List;
import model.*;
import strategies.*;

public interface OrderFactory{
    Order createOrder(User user,Cart cart,Restaurant restaurant,
    List<MenuItem> menuItems,PaymentStrategy paymentStrategy,double totalCost,String orderType);
}