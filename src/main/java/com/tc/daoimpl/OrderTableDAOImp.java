package com.tc.daoimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.dao.OrderTableDAO;
import com.tc.model.Cart;
import com.tc.model.OrderHistory;
import com.tc.model.OrderItem;
import com.tc.model.OrderTable;
import com.tc.util.HibernateUtil;

public class OrderTableDAOImp implements OrderTableDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getConfiguration()
            .addAnnotatedClass(OrderTable.class)
            .addAnnotatedClass(OrderItem.class)
            .addAnnotatedClass(OrderHistory.class)
            .buildSessionFactory();

    @Override
    public void insertOrderDetails(int userId, int restaurantId, String status, float totalAmount, Collection<Cart> cartItems,String paymentMethod) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            LocalDateTime currentTime = LocalDateTime.now();

            // Create new OrderTable object
            OrderTable orderTable = new OrderTable(userId, restaurantId, status, currentTime, totalAmount);
            session.save(orderTable);
            

            // Create OrderItem objects
            for (Cart cart : cartItems) {
                OrderItem orderItem = new OrderItem();
                orderItem.setMenuId(cart.getMenuId());
                orderItem.setQuantity(cart.getQuantity());
                orderItem.setItemAmount(cart.getAmount());
                orderItem.setOrderTable(orderTable); 
                
                session.save(orderItem);
            }
            
            // create OrderHistory
            OrderHistory orderHistory=new OrderHistory();
            orderHistory.setOrderTable(orderTable);
            orderHistory.setUserId(userId);
            orderHistory.setTotalAmount(totalAmount);
            orderHistory.setOrderDate(LocalDate.now());
            orderHistory.setpaymentMethod(paymentMethod);
            session.save(orderHistory);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); 
            }
            e.printStackTrace();
        }
    }
    
    public List<OrderHistory> getHistory(int userId) {
        List<OrderHistory> history = new ArrayList<>();
        
        try (Session session = sessionFactory.openSession()) {
            Query<OrderHistory> query = session.createQuery("from OrderHistory where userId = :userId", OrderHistory.class);
            query.setParameter("userId", userId);
            history = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return history;
    }

}
