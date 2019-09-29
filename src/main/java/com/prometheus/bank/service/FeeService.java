package com.prometheus.bank.service;

import com.prometheus.bank.entity.ServiceFee;

import java.util.List;

public interface FeeService extends IService<ServiceFee> {

    List<ServiceFee> getAllServiceFees();

    ServiceFee getServiceFee(String type);

    void saveServiceFee(ServiceFee serviceFee);

    void updateServiceFee(ServiceFee serviceFee);

    void deleteServiceFee(long id);

}
