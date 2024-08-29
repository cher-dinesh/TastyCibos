package com.tc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.dao.MenuDAO;
import com.tc.model.Menu;
import com.tc.util.HibernateUtil;

public class MenuDAOImp implements MenuDAO {

    private static SessionFactory sessionFactory = HibernateUtil.getConfiguration().addAnnotatedClass(Menu.class).buildSessionFactory();

    @Override
    public List<Menu> getMenu(int restaurantId) {
        List<Menu> menuItems = new ArrayList<>();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Query<Menu> query = session.createQuery("FROM Menu WHERE restaurantId = :restaurantId", Menu.class);
            query.setParameter("restaurantId", restaurantId);
            menuItems = query.list();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuItems;
    }

    @Override
    public float getPriceByMenuId(int menuId) {
        float price = 0.0f;
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Query<Menu> query = session.createQuery("FROM Menu WHERE menuId = :menuId", Menu.class);
            query.setParameter("menuId", menuId);
            Menu menu = query.uniqueResult();

            if (menu != null) {
                price = menu.getPrice();
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return price;
    }
}
