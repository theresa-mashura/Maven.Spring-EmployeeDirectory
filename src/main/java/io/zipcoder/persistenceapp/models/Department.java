package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long departmentNumber;
    private String departmentName;
    private long departmentManagerId;

    public Department() {

    }

    public Department(long departmentNumber, String departmentName, long departmentManagerId) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.departmentManagerId = departmentManagerId;
    }

    public long getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getDepartmentManagerId() {
        return departmentManagerId;
    }

    public void setDepartmentManagerId(long departmentManagerId) {
        this.departmentManagerId = departmentManagerId;
    }
}


