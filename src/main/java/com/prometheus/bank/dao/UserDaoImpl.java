package com.prometheus.bank.dao;

import com.prometheus.bank.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(long id) {
        return get(id);
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE username='"+username+"'", User.class);
        User user = (User) query.getSingleResult();

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return getAll();
    }

    @Override
    public void saveUser(User user) {
        save(user);
    }

    @Override
    public void updateUser(User user) {
        update(user);
    }

    @Override
    public void deleteUser(long id) {
        delete(id);
    }
}
