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

    public Department(Long id, String departmentName, Long departmentManagerId) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentManagerId = departmentManagerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


