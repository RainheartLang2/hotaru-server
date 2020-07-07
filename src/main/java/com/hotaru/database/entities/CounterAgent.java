package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.PersonType;
import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name="counterAgent")
@Entity(name="counterAgent")
public class CounterAgent implements Identifiable, Archivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="contactPersonName", length = 100)
    private String contactPersonName;

    @Column(name="personType", length = 7)
    private PersonType personType;

    @Column(name="deleted")
    private boolean deleted;

    @Column(name="phone", length = 15)
    private String phone;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="personFinancialId", length = 50)
    private String personFinancialId;

    @Column(name="bankName", length = 200)
    private String bankName;

    @Column(name="bankId", length = 100)
    private String bankId;

    @Column(name="correspondentAccount", length = 50)
    private String correspondentAccount;

    @Column(name="gyroAccount", length = 50)
    private String gyroAccount;

    @Column(name="note", length = 2000)
    private String note;

    public CounterAgent() {}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public String getPersonFinancialId() {
        return personFinancialId;
    }

    public void setPersonFinancialId(String personFinancialId) {
        this.personFinancialId = personFinancialId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getCorrespondentAccount() {
        return correspondentAccount;
    }

    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public String getGyroAccount() {
        return gyroAccount;
    }

    public void setGyroAccount(String gyroAccount) {
        this.gyroAccount = gyroAccount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }
}
