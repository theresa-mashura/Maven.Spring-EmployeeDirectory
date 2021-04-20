package io.zipcoder.persistenceapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long employeeNumber;

    private String firstName;
    private String lastName;
    private String title;
    private String phoneNumber;
    private String email;
    private String hireDate;
    private long departmentNumber;

    @ManyToOne
    private Employee manager;

    public Employee() {

    }

    public Employee(long employeeNumber, String firstName, String lastName, String title, String phoneNumber, String email, String hireDate, long departmentNumber, Employee manager) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.departmentNumber = departmentNumber;
        this.manager = manager;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public long getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
