package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue
    private Long departmentNumber;
    private String departmentName;
    private Long departmentManagerId;

    public Department() {

    }

    public Department(long departmentNumber, String departmentName, long departmentManagerId) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.departmentManagerId = departmentManagerId;
    }

    public Long getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getDepartmentManagerId() {
        return departmentManagerId;
    }

    public void setDepartmentManagerId(Long departmentManagerId) {
        this.departmentManagerId = departmentManagerId;
    }
}


