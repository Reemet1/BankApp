package com.prometheus.bank.dao;

import com.prometheus.bank.entity.ServiceFee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceFeeDAOImpl extends GenericDaoImpl<ServiceFee> implements ServiceFeeDAO {

    @Override
    public List<ServiceFee> getAllServiceFees() {
        return super.getAll();
    }

    @Override
    public ServiceFee getServiceFee(String type) {
        return null;
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
