package com.prometheus.bank.service;

import java.util.List;

public interface IService<T> {

    T get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(long id);

}
