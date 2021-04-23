package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    private DepartmentService ds;

    @Autowired
    public DepartmentController(DepartmentService ds){
        this.ds = ds;
    }

    // GET - ALL DEPTS
    @RequestMapping(value = "/API/department", method = RequestMethod.GET)
    public Iterable<Department> getAllDepts() {
        return this.ds.findAll();
    }

    // POST - CREATE DEPARTMENT
    @RequestMapping(value = "/API/department", method = RequestMethod.POST)
    public Department createDepartment(@RequestBody Department department) {
        return this.ds.create(department);
    }

    // UPDATE - SET NEW DEPT MANAGER
    @RequestMapping(value = "/API/department/{deptId}/manager/{id}", method = RequestMethod.PATCH)
    public Department updateDepartmentManager(@PathVariable("deptId") Long deptId, @PathVariable("id") Long id) {
        return this.ds.update(deptId, id);
    }

    // UPDATE - CHANGE DEPT NAME
    @RequestMapping(value = "/API/department/{deptId}/name/{name}", method = RequestMethod.PATCH)
    public Department updateDepartmentName(@PathVariable("deptId") Long deptId, @PathVariable("name") String name) {
        return this.ds.update(deptId, name);
    }

    // REMOVE ALL EMPLOYEES FROM A PARTICULAR DEPT

    // GET ALL EMPLOYEES OF PARTICULAR DEPT

    // MERGE DEPTS (A & B - MANAGER OF B WILL REPORT TO A & EMPLOYEES IN B WILL MOVE TO A)


}
