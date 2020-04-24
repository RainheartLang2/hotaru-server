package com.hotaru.database.entities;

import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name = "employee")
@Entity(name = "employee")
public class Employee implements Identifiable, Archivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 100)
    @NotNull
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", length = 100)
    @NotNull
    private String lastName;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 254)
    private String email;

    @Column(name = "address", length = 1024)
    private String address;

    public Employee() {
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (employee.getPhone() != null) {
            this.setPhone(employee.getPhone());
        }
        if (employee.getEmail() != null) {
            this.setEmail(employee.getEmail());
        }
        if (employee.getAddress() != null) {
            this.setAddress(employee.getAddress());
        }
    }
}