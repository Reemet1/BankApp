package com.prometheus.bank.service;

import com.prometheus.bank.dao.UserDAO;
import com.prometheus.bank.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(long id) {
        return get(id);
    }

    @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
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
