package com.hotaru.database.entities;

import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name = "breed")
@Entity(name = "breed")
public class Breed implements Identifiable, Archivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 200)
    @NotNull
    private String name;

    @Column(name = "speciesId")
    private int speciesId;

    @Column(name = "deleted")
    private boolean deleted;

    public Breed() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
