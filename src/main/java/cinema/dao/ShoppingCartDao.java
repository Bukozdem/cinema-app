package cinema.dao;

import cinema.model.User;
import cinema.model.ShoppingCart;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
