package cinema.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cinema.dao.OrderDao;
import cinema.lib.Inject;
import cinema.model.Ticket;
import cinema.model.User;
import cinema.service.ShoppingCartService;
import cinema.lib.Service;
import cinema.model.Order;
import cinema.model.ShoppingCart;
import cinema.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        logger.info("Shopping cart by id {} was completed", shoppingCart.getId());
        List<Ticket> tickets = new ArrayList<>(shoppingCart.getTickets());
        User user = shoppingCart.getUser();
        Order order = new Order();
        order.setTickets(tickets);
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        orderDao.add(order);
        shoppingCartService.clearShoppingCart(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getByUser(user);
    }
}
