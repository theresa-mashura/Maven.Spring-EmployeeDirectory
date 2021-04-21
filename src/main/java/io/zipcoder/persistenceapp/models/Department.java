package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    private String departmentName;
    private Long departmentManagerId;

    public Department() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long departmentNumber) {
        this.id = departmentNumber;
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


