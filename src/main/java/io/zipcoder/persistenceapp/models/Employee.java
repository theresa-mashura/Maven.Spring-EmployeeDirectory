package io.zipcoder.persistenceapp.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String title;
    private String phoneNumber;
    private String email;
    private String hireDate;

    private Long departmentId;
//    @ManyToOne  // There are MANY employees in ONE department
//    @JoinColumn(name = "departmentId", referencedColumnName = "id", insertable = false, updatable = false)
//    private Department department;

    private Long managerId;
    @ManyToOne  // There are MANY employees for ONE manager
    @JoinColumn(name = "managerId", referencedColumnName = "id", insertable = false, updatable = false)
    private Employee manager;

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", managerId=" + managerId +
                '}';
    }
}
