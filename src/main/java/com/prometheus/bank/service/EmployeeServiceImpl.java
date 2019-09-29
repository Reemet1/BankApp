package com.prometheus.bank.service;

import com.prometheus.bank.entity.Employee;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractService<Employee> implements EmployeeService {

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
