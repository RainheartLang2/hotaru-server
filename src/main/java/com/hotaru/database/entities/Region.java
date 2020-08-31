package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name = "region")
@Entity(name = "region")
public class Region implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

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
}
