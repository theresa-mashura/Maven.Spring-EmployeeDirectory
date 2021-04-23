package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {

    private DepartmentService ds;

    @Autowired
    public DepartmentController(DepartmentService ds){
        this.ds = ds;
    }

    // POST - CREATE DEPARTMENT
    @RequestMapping(value = "/API/department", method = RequestMethod.POST)
    public Department createDepartment(@RequestBody Department department) {
        return this.ds.create(department);
    }

    // UPDATE - SET NEW DEPT MANAGER
    @RequestMapping(value = "/API/department/{deptId}/manager/{id}", method = RequestMethod.PATCH)
    public Department updateDepartmentManager(@PathVariable("deptId") Long deptId, Long id) {
        return this.ds.update(deptId, id);
    }

    // UPDATE - CHANGE DEPT NAME


}
