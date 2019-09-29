package com.prometheus.bank.dao;

import com.prometheus.bank.entity.User;

import java.util.List;

public interface UserDAO extends IGenericDAO<User> {

    User getUser(long id);

    User getUser(String username);

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

}
