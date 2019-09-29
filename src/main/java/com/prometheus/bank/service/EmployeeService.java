package com.prometheus.bank.service;

import com.prometheus.bank.entity.Employee;

import java.util.List;

public interface EmployeeService extends IService<Employee> {

    Employee getEmployee(long id);

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(long id);

}
