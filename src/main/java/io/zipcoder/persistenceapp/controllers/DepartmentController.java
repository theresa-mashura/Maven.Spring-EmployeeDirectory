package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DepartmentController {

    private DepartmentService deptService;

    @Autowired
    public DepartmentController(DepartmentService deptService){
        this.deptService = deptService;
    }

    // POST - CREATE DEPARTMENT

    // UPDATE - SET NEW DEPT MANAGER

    // UPDATE - CHANGE DEPT NAME


}
