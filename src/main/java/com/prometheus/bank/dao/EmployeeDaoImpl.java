package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee> implements EmployeeDAO {

    @Override
    public Employee getEmployee(long id) {
        return get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        update(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        delete(id);
    }
}
