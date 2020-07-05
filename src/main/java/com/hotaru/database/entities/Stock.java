package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.SalesType;
import com.hotaru.business.logic.enums.StockType;
import com.hotaru.core.database.Archivable;
import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name="stock")
@Entity(name="stock")
public class Stock implements Identifiable, Archivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="stockType", length = 7)
    private StockType stockType;

    @Column(name="deleted")
    private boolean deleted;

    @Column(name="responsiblePersonId")
    private int responsiblePersonId;

    @Column(name="clinicId")
    private int clinicId;

    public Stock() {}

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

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getResponsiblePersonId() {
        return responsiblePersonId;
    }

    public void setResponsiblePersonId(int responsiblePersonId) {
        this.responsiblePersonId = responsiblePersonId;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }
}
