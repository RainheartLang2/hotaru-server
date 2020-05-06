package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.ClientType;
import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Entity(name="client")
@Table(name="client")
public class Client implements Identifiable, Archivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name", length=100)
    private String firstName;

    @Column(name="middle_name", length=100)
    private String middleName;

    @Column(name="last_name", length=100)
    private String lastName;

    @Column(name="type")
    private ClientType type;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name="address", length=1024)
    private String address;

    @Column(name="email", length=254)
    private String email;

    @Column(name="deleted")
    private boolean deleted;

    public Client() {
    }

    public int getId() {
        return id;
    }

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

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
