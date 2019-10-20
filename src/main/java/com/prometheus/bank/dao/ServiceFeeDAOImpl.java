package com.prometheus.bank.dao;

import com.prometheus.bank.entity.ServiceFee;
import com.prometheus.bank.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ServiceFeeDAOImpl extends GenericDaoImpl<ServiceFee> implements ServiceFeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ServiceFee> getAllServiceFees() {
        return super.getAll();
    }

    @Override
    public ServiceFee getServiceFee(String type) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ServiceFee WHERE type='"+type+"'", ServiceFee.class);
        ServiceFee serviceFee = (ServiceFee) query.getSingleResult();

        return serviceFee;
    }

    @Override
    public void saveServiceFee(ServiceFee serviceFee) {
        super.save(serviceFee);
    }

    @Override
    public void updateServiceFee(ServiceFee serviceFee) {
        super.update(serviceFee);
    }

    @Override
    public void deleteServiceFee(long id) {
        super.delete(id);
    }
}
