package cinema.service;

import java.util.List;

import cinema.model.User;
import cinema.model.Order;
import cinema.model.ShoppingCart;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
