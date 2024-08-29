package com.tc.daoimpl;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.dao.UserDAO;
import com.tc.model.User;
import com.tc.util.HibernateUtil;

public class UserDAOImp implements UserDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getConfiguration().addAnnotatedClass(User.class).buildSessionFactory();
    Session session = null;
    Transaction transaction = null;

    @Override
    public int getUserByEmail(String email) {
        int result = 0;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<User> query = session.createQuery("from User where email = :email", User.class);
            query.setParameter("email", email);
            User user = query.uniqueResult();

            if (user != null) {
                result = 1;
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return result;
    }

    @Override
    public int addUser(User u) {
        int result = 0;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(u);

            transaction.commit();
            result = 1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return result;
    }

    @Override
    public User getUserByEmail(String email, String password) {
        User user = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<User> query = session.createQuery("from User where email = :email and password = :password", User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            user = query.uniqueResult();

            if (user != null) {
                user.setLastLogin(LocalDateTime.now());
                session.update(user);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return user;
    }
    
    public void updateUser(User u) {
    	try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            session.update(u);
            
            transaction.commit();    
    	}catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
