package io.zipcoder.persistenceapp.services;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

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
        e.setId(employee.getId());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setHireDate(employee.getHireDate());
        e.setManager(employee.getManager());
        e.setManagerId(employee.getManagerId());
        e.setTitle(employee.getTitle());
        e.setPhoneNumber(employee.getPhoneNumber());
        this.employeeRepository.save(e);
        return e;
    }

    public Employee updateManager(Long id, Long managerId) {
        if (this.employeeRepository.findOne(managerId) != null) {
            Employee e = this.employeeRepository.findOne(id);
            e.setManagerId(managerId);
            this.employeeRepository.save(e);
            return e;
        }

        return null;
    }

    public List<Employee> findByManger(Long id) {
        return this.employeeRepository.findByManagerId(id);
    }

    public List<Employee> getReportingHierarchy(Long empId) {
        Employee currentManager = this.employeeRepository.findOne(empId).getManager();
        List<Employee> reportingTo = new ArrayList<>();

        while(currentManager.getManager() != null) {
            reportingTo.add(currentManager);
            currentManager = currentManager.getManager();
        }
        return reportingTo;
    }

    public List<Employee> getDirectAndIndirectReports(Long mgrId) {
        List<Long> empIds = new ArrayList<>();
        List<Employee> directReports = this.findByManger(mgrId);

        for (Employee emp : directReports) {
            empIds.add(emp.getId());
        }

    }


}
