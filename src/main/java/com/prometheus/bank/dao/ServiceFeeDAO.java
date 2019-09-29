package com.prometheus.bank.dao;

import com.prometheus.bank.entity.ServiceFee;

import java.util.List;

public interface ServiceFeeDAO extends IGenericDAO<ServiceFee> {

    List<ServiceFee> getAllServiceFees();

    ServiceFee getServiceFee(String type);

    void saveServiceFee(ServiceFee serviceFee);

    void updateServiceFee(ServiceFee serviceFee);

    void deleteServiceFee(long id);

}
