package com.springapplicationusingxml.DaosImpl;

import com.springapplicationusingxml.Daos.UserDao;
import com.springapplicationusingxml.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by muhamamddanish on 10/7/16.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    @Override
    public User getUser(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = (User) session.createQuery("from User u Where u.firstName = ? ").setString(0,name).uniqueResult();
        tx.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<User> users = (List<User>) session.createQuery("from User").list();
        tx.commit();
        session.close();

        return users;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from User where userId =:id").setInteger("id",id).executeUpdate();
        tx.commit();
        session.close();
    }
}
