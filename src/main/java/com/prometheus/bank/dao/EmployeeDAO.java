package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends IGenericDAO<Employee> {

    Employee getEmployee(long id);

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(long id);

}
