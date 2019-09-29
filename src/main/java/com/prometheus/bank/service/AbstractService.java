package com.prometheus.bank.service;

import com.prometheus.bank.dao.IGenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public abstract class AbstractService<T> implements IService<T> {

    @Autowired
    IGenericDAO<T> genericDAO;

    @Override
    public T get(long id) {
        return genericDAO.get(id);
    }

    @Override
    public List<T> getAll() {
        return genericDAO.getAll();
    }

    @Override
    public void save(T t) {
        genericDAO.save(t);
    }

    @Override
    public void update(T t) {
        genericDAO.update(t);
    }

    @Override
    public void delete(long id) {
        genericDAO.delete(id);
    }

}
