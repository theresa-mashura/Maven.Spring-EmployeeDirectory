package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department show(long id) {
        return departmentRepository.findOne(id);
    }

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Long deptId, Long managerId) {
        Department d = departmentRepository.findOne(deptId);
        d.setDepartmentManagerId(managerId);
        this.departmentRepository.save(d);
        return d;
    }

    public Boolean delete(Long id) {
        this.departmentRepository.delete(id);
        return true;
    }
}
