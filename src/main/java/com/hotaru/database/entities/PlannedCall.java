package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.PlannedCallStateType;
import com.hotaru.core.database.Identifiable;

import javax.persistence.*;
import java.util.Date;

@Table(name="plannedCall")
@Entity(name="plannedCall")
public class PlannedCall implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="clinicId")
    private int clinicId;

    @Column(name="clientId")
    private int clientId;

    @Column(name="petId")
    private Integer petId;

    @Column(name="doctorId")
    private int doctorId;

    @Column(name="callDate")
    private Date callDate;

    @Column(name="note")
    private String note;

    @Column(name="state")
    private PlannedCallStateType state;

    public PlannedCall() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PlannedCallStateType getState() {
        return state;
    }

    public void setState(PlannedCallStateType state) {
        this.state = state;
    }
}
