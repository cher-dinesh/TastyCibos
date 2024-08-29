package com.tc.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tc.dao.RestaurantDao;
import com.tc.model.Restaurant;
import com.tc.util.HibernateUtil;

public class RestaurantDAOImp implements RestaurantDao {
	Session session=null;
	Transaction transaction = null;
	
	public RestaurantDAOImp() {
		try {
        	Configuration config= HibernateUtil.getConfiguration().addAnnotatedClass(Restaurant.class);
        	session=config.buildSessionFactory().openSession();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Override
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurants = null;

        try {
            restaurants = session.createQuery("from Restaurant", Restaurant.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public String getRestaurantName(int restaurantId) {
        String restaurantName = null;

        try {
            Query<String> query = session.createQuery("select r.restaurantName from Restaurant r where r.restaurantId = :restaurantId", String.class);
            query.setParameter("restaurantId", restaurantId);
            restaurantName = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurantName;
    }
}
