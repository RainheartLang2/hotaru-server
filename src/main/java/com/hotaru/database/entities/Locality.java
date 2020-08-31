package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name = "locality")
@Entity(name = "locality")
public class Locality implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "regionId")
    private int regionId;

    @Column(name = "distance", length = 5)
    private int distance;
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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
