package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.SalesType;
import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name="salesUnit")
@Entity(name="salesUnit")
public class SalesUnit implements Identifiable, Archivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="salesType", length = 7)
    private SalesType salesType;

    @Column(name="deleted")
    private boolean deleted;

    private int categoryId;

    private int measureUnitId;

    private double price;

    public SalesUnit() {}

    public SalesUnit(String name, SalesType type, int salesCategoryId, int measureUnitId) {
        this.name = name;
        this.salesType = type;
        this.categoryId = salesCategoryId;
        this.measureUnitId = measureUnitId;
        this.deleted = false;
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

    public SalesType getSalesType() {
        return salesType;
    }

    public void setSalesType(SalesType salesType) {
        this.salesType = salesType;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getMeasureUnitId() {
        return measureUnitId;
    }

    public void setMeasureUnitId(int measureUnitId) {
        this.measureUnitId = measureUnitId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
