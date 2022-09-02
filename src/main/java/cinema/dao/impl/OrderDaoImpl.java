package cinema.dao.impl;

import java.util.List;

import cinema.dao.OrderDao;
import cinema.exception.DataProcessingException;
import cinema.model.User;
import cinema.lib.Dao;
import cinema.model.Order;
import cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn`t add order " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Order o "
                            + "left join fetch o.user "
                            + "left join fetch o.tickets t "
                            + "left join fetch t.user "
                            + "left join fetch t.movieSession m "
                            + "left join fetch m.movie "
                            + "left join fetch m.cinemaHall "
                            + "where o.user = :user", Order.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get order by user " + user, e);
        }
    }
}
