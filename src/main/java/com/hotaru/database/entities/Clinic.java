package com.hotaru.database.entities;

import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.TimeZone;

@Table(name = "clinic")
@Entity(name = "clinic")
public class Clinic implements Identifiable, Archivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 200)
    @NotNull
    private String name;

    @Column(name = "address", length = 1024)
    private String address;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "timezone")
    private TimeZone timeZone;

    public Clinic() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
