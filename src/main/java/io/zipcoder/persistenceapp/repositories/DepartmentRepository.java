package io.zipcoder.persistenceapp.repositories;


import io.zipcoder.persistenceapp.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
