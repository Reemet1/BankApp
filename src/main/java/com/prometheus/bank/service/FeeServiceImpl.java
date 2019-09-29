package com.prometheus.bank.service;

import com.prometheus.bank.dao.ServiceFeeDAO;
import com.prometheus.bank.entity.ServiceFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeServiceImpl extends AbstractService<ServiceFee> implements FeeService {

    @Autowired
    private ServiceFeeDAO serviceFeeDAO;

    @Override
    public List<ServiceFee> getAllServiceFees() {
        return serviceFeeDAO.getAllServiceFees();
    }

    @Override
    public ServiceFee getServiceFee(String type) {
        return serviceFeeDAO.getServiceFee(type);
    }

    @Override
    public void saveServiceFee(ServiceFee serviceFee) {
        serviceFeeDAO.saveServiceFee(serviceFee);
    }

    @Override
    public void updateServiceFee(ServiceFee serviceFee) {
        serviceFeeDAO.updateServiceFee(serviceFee);
    }

    @Override
    public void deleteServiceFee(long id) {
        serviceFeeDAO.deleteServiceFee(id);
    }
}
