package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="appointment")
@Table(name="appointment")
public class Appointment implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 100)
    @NotNull
    private String title;

    @Column(name = "startDate")
    @NotNull
    private Date startDate;

    @Column(name = "endDate")
    @NotNull
    private Date endDate;

    public Appointment() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
