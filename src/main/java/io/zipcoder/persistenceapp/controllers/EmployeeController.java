package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService es;

    @Autowired
    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

    // POST - CREATE EMPLOYEE
    @RequestMapping(value = "/API", method = RequestMethod.POST)
    public Employee createNewEmployee(Employee employee) {
        return es.create(employee);
    }

    // UPDATE - SET EMPLOYEE MANAGER

    // UPDATE - OTHER FIELDS

    // GET - LIST EMPLOYEES UNDER PARTICULAR MANAGER

    // GET REPORTING HIERARCHY FOR AN EMPLOYEE (MANAGER, MANAGER'S MANAGER, ETC.)

    // GET EMPLOYEES WITH NO MANAGER

    // GET ALL EMPLOYEES OF PARTICULAR DEPT

    // GET ALL EMPLOYEES WHO REPORT DIRECTLY OR INDIRECTLY TO A PARTICULAR MANAGER

    // REMOVE PARTICULAR EMPLOYEE OR LIST OF EMPLOYEES

    // REMOVE ALL EMPLOYEES FROM A PARTICULAR DEPT

    // REMOVE ALL EMPLOYEES UNDER A PARTICULAR MANAGER (INCL INDIRECT REPORTS)

    // REMOVE ALL DIRECT REPORTS TO A MANAGER (EMPLOYEES UNDER THEM SHOULD NOW BE MANAGED BY NEW MANAGER IN HIERARCHY)

    // GET DEPT, TITLE, OR OTHER ATTRIBUTES OF AN EMPLOYEE

    // MERGE DEPTS (A & B - MANAGER OF B WILL REPORT TO A & EMPLOYEES IN B WILL MOVE TO A)

}
