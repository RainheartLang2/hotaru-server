package com.hotaru.database.entities;

import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name="visitResult")
@Entity(name="visitResult")
public class VisitResult implements Identifiable, Archivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length=100)
    private String name;

    @Column(name="deleted")
    private boolean deleted;

    public VisitResult() {
    }

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

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
