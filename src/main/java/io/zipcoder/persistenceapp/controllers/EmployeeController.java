package io.zipcoder.persistenceapp.controllers;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping(value = "/API/employee/{id}/manager/{managerId}", method = RequestMethod.PATCH)
    public Employee setManager(@PathVariable Long id, @PathVariable Long managerId) {
        return this.es.updateManager(id, managerId);
    }

    // GET REPORTING HIERARCHY FOR AN EMPLOYEE (MANAGER, MANAGER'S MANAGER, ETC.)
    @RequestMapping(value = "/API/employee/{id}/manager/all", method = RequestMethod.GET)
    public List<Employee> getReportingHierarchy(@PathVariable Long id) {
        return this.es.getReportingHierarchy(id);
    }

    // GET EMPLOYEES WITH NO MANAGER
    @RequestMapping(value = "/API/employee/manager/none", method = RequestMethod.GET)
    public List<Employee> getEmployeesNoManager() {
        return this.es.findByManger(null);
    }

    // GET ALL EMPLOYEES WHO REPORT DIRECTLY OR INDIRECTLY TO A PARTICULAR MANAGER
    @RequestMapping(value = "/API/employee/reports/manager/{id}", method = RequestMethod.GET)
    public List<Long> getEmployeesUnderManager(@PathVariable  Long id) {
        return this.es.getDirectAndIndirectReports(id);
    }

    // REMOVE PARTICULAR EMPLOYEE OR LIST OF EMPLOYEES
    @RequestMapping(value = "/API/employee", method = RequestMethod.DELETE)
    public List<Boolean> removeEmployees(@RequestBody List<Long> employeeIds) {
        return this.es.delete(employeeIds);
    }

    // REMOVE ALL EMPLOYEES UNDER A PARTICULAR MANAGER (INCL INDIRECT REPORTS)
    @RequestMapping(value = "/API/employee/manager/{id}", method = RequestMethod.DELETE)
    public List<Boolean> removeEmployeesUnderManager(@PathVariable("id") Long managerId) {
        return this.es.deleteEmployeeUnderManager(managerId);
    }

    // GET - LIST EMPLOYEES UNDER PARTICULAR MANAGER
    @RequestMapping(value = "/API/employee/manager/{id}", method = RequestMethod.GET)
    public List<Employee> findEmployeesUnderManager(@PathVariable Long id) {
        return this.es.findByManger(id);
    }

    // REMOVE ALL DIRECT REPORTS TO A MANAGER (EMPLOYEES UNDER THEM SHOULD NOW BE MANAGED BY NEW MANAGER IN HIERARCHY)
    @RequestMapping(value = "/API/employee/direct-reports/manager/{id}", method = RequestMethod.DELETE)
    public List<Employee> removeDirectReportsToManager(@PathVariable("id") Long managerId) {
        Long newManager = this.es.show(managerId).getManagerId();
        if (newManager != null) {
            List<Employee> directReports = this.es.findByManger(managerId);
            List<Long> directReportIds = new ArrayList<>();
            List<Employee> indirectReports;
            for (Employee e : directReports) {
                indirectReports = this.es.findByManger(e.getId());
                for (Employee i : indirectReports) {
                    this.es.updateManager(i.getId(), newManager);
                }
                directReportIds.add(e.getId());
            }
            this.es.delete(directReportIds);
            return directReports;
        }
        return null;
    }

    // FIND ALL EMPLOYEES FROM A PARTICULAR DEPARTMENT
    @RequestMapping(value = "/API/employee/all/department/{id}", method = RequestMethod.GET)
    public Iterable<Employee> findAllInDepartment(@PathVariable Long id) {
            return this.es.findAllFromDepartment(id);
    }

    // DELETE ALL EMPLOYEES FROM A PARTICULAR DEPARTMENT
    @RequestMapping(value = "/API/employee/all/department/{id}", method = RequestMethod.DELETE)
    public void deleteAllInDepartment(@PathVariable Long id) {
        this.es.deleteAllFromDept(id);
    }

    // MERGE DEPTS (A & B - MANAGER OF B WILL REPORT TO A & EMPLOYEES IN B WILL MOVE TO A)
    @RequestMapping(value = "/API/departments/merge/to/{mergeTo}/from/{mergeFrom}", method = RequestMethod.PUT)
    public Iterable<Employee> mergeDeptBIntoDeptA(@PathVariable Long mergeTo, @PathVariable Long mergeFrom) {
        return this.es.mergeDepartmentBIntoA(mergeTo, mergeFrom);
    }
}
