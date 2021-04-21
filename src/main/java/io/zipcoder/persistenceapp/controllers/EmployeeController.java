package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    private EmployeeService es;

    @Autowired
    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

    // POST - CREATE EMPLOYEE
    @RequestMapping(value = "/API/employee", method = RequestMethod.POST)
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return es.create(employee);
    }

    // GET ALL EMPLOYEES
    @RequestMapping(value = "/API/employee", method = RequestMethod.GET)
    public Iterable<Employee> getAllEmployees() {
        return this.es.findAll();
    }

    // GET DEPT, TITLE, OR OTHER ATTRIBUTES OF AN EMPLOYEE
    @RequestMapping(value = "/API/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Long id) {
        return this.es.show(id);
    }

    // UPDATE - OTHER FIELDS
    @RequestMapping(value = "/API/employee/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return this.es.update(id, employee);
    }

    // UPDATE - SET EMPLOYEE MANAGER
//    @RequestMapping(value = "/API/employee/{id}", method = RequestMethod.PATCH)
//    public Employee setManager(@PathVariable Long id, @RequestBody Employee employeeManager) {
//
//        return this.es.update()
//    }

    // GET - LIST EMPLOYEES UNDER PARTICULAR MANAGER

    // GET REPORTING HIERARCHY FOR AN EMPLOYEE (MANAGER, MANAGER'S MANAGER, ETC.)

    // GET EMPLOYEES WITH NO MANAGER

    // GET ALL EMPLOYEES OF PARTICULAR DEPT

    // GET ALL EMPLOYEES WHO REPORT DIRECTLY OR INDIRECTLY TO A PARTICULAR MANAGER

    // REMOVE PARTICULAR EMPLOYEE OR LIST OF EMPLOYEES

    // REMOVE ALL EMPLOYEES FROM A PARTICULAR DEPT

    // REMOVE ALL EMPLOYEES UNDER A PARTICULAR MANAGER (INCL INDIRECT REPORTS)

    // REMOVE ALL DIRECT REPORTS TO A MANAGER (EMPLOYEES UNDER THEM SHOULD NOW BE MANAGED BY NEW MANAGER IN HIERARCHY)


    // MERGE DEPTS (A & B - MANAGER OF B WILL REPORT TO A & EMPLOYEES IN B WILL MOVE TO A)

}
