package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.Sex;
import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Table(name="pet")
@Entity(name="pet")
public class Pet implements Archivable, Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="speciesId")
    private Integer speciesId;

    @Column(name="breedId")
    private Integer breedId;

    @Column(name="name")
    private String name;

    @Column(name="ownerId")
    @NotNull
    private int ownerId;

    @Column(name="deleted")
    private boolean deleted;

    @Column(name="petSex", length=6)
    private Sex petSex;

    @Column(name="colorId")
    private Integer colorId;

    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="note", length = 2048)
    private String note;

    public Pet() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Integer getBreedId() {
        return breedId;
    }

    public void setBreedId(Integer breedId) {
        this.breedId = breedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Sex getPetSex() {
        return petSex;
    }

    public void setPetSex(Sex petSex) {
        this.petSex = petSex;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Integer speciesId) {
        this.speciesId = speciesId;
    }
}
