package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name="employee")
@Entity(name = "employee")
public class Employee implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="deleted")
    private boolean deleted;

    @Column(name="active")
    private Boolean active;

    public Employee() {}

    public Employee(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.deleted = false;
        this.active = true;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void merge(Employee employee) {
        if (employee.getFirstName() != null) {
            this.setFirstName(employee.getFirstName());
        }
        if (employee.getMiddleName() != null) {
            this.setMiddleName(employee.getMiddleName());
        }
        if (employee.getLastName() != null) {
            this.setLastName(employee.getLastName());
        }
        if (employee.isActive() != null) {
            this.setActive(employee.isActive());
        }
    }
}