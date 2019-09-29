package com.prometheus.bank.dao;

import com.prometheus.bank.entity.EmployeeDetails;

import java.util.List;

public interface EmployeeDetailsDAO extends IGenericDAO<EmployeeDetails> {

    EmployeeDetails getEmployeeDetails(long id);

    List<EmployeeDetails> getAllEmployeeDetails();

    void saveEmployeeDetails(EmployeeDetails employeeDetails);

    void updateEmployeeDetails(EmployeeDetails employeeDetails);

    void deleteEmployeeDetails(long id);

}
