package com.prometheus.bank.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Consumer;

@Component
@Transactional
public abstract class GenericDaoImpl<T> implements IGenericDAO<T> {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private final Class<T> type;

    public GenericDaoImpl() {

        this.type = (Class<T>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
        System.out.println();
    }

    protected EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public T get(long id) {
        return getEntityManager().find(type, id);
    }

    @Override
    public List<T> getAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM " + type.getName() + " e");
        return query.getResultList();
    }

    @Override
    public void save(T t) {
        executeInsideTransaction(entityManager -> entityManager.persist(t));
    }

    @Override
    public void update(T t) {
        executeInsideTransaction(entityManager -> entityManager.merge(t));
    }

    @Override
    public void delete(long id) {
        executeInsideTransaction(entityManager -> entityManager.remove(id));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityManager entityManager = getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
