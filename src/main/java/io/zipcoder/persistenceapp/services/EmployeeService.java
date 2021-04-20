package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public Employee show(Long id) {
        return this.employeeRepository.findOne(id);
    }

    public Boolean delete(Long id) {
        this.employeeRepository.delete(id);
        return true;
    }

    public Employee update(Long id, Employee employee) {
        Employee e = this.employeeRepository.findOne(id);
        e.setDepartmentNumber(employee.getDepartmentNumber());
        e.setEmail(employee.getEmail());
        e.setEmployeeNumber(employee.getEmployeeNumber());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setHireDate(employee.getHireDate());
        e.setManager(employee.getManager());
        e.setTitle(employee.getTitle());
        e.setPhoneNumber(employee.getPhoneNumber());
        return e;
    }


}
