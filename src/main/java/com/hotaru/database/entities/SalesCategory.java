package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.SalesType;
import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name="salesCategory")
@Entity(name="salesCategory")
public class SalesCategory implements Identifiable, Archivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="salesType", length = 7)
    private SalesType salesType;

    @Column(name="extraCharge")
    private double extraCharge;

    @Column(name="deleted")
    private boolean deleted;

    public SalesCategory() {
    }

    public SalesCategory(String name, SalesType type, double extraCharge) {
        this.name = name;
        this.salesType = type;
        this.extraCharge = extraCharge;
    }

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

    public SalesType getSalesType() {
        return salesType;
    }

    public void setSalesType(SalesType salesType) {
        this.salesType = salesType;
    }

    public double getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(double extraCharge) {
        this.extraCharge = extraCharge;
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
