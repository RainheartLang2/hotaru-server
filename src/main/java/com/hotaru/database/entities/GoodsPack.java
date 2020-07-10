package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Table(name = "goodsPack")
@Entity(name = "goodsPack")
public class GoodsPack implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "stockId")
    @NotNull
    private int stockId;

    @Column(name = "goodsTypeId")
    @NotNull
    private int goodsTypeId;

    @Column(name = "goodsProducerId")
    private Integer goodsProducerId;

    @Column(name = "incomeDocumentId")
    @NotNull
    private int incomeDocumentId;

    @Column(name = "amount")
    @NotNull
    private int amount;

    @Column(name = "series", length = 100)
    private String series;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "expirationDate")
    private Date expirationDate;

    public GoodsPack() {
    }

    public GoodsPack(GoodsPackWithPrice packWithPrice, GoodsDocument incomeDocument) {
        this.amount = packWithPrice.getAmount();
        this.creationDate = packWithPrice.getCreationDate();
        this.expirationDate = packWithPrice.getExpirationDate();
        this.goodsProducerId = packWithPrice.getGoodsProducerId();
        this.goodsTypeId = packWithPrice.getGoodsTypeId();
        this.stockId = packWithPrice.getStockId();
        this.incomeDocumentId = incomeDocument.getId();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Integer getGoodsProducerId() {
        return goodsProducerId;
    }

    public void setGoodsProducerId(Integer goodsProducerId) {
        this.goodsProducerId = goodsProducerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIncomeDocumentId() {
        return incomeDocumentId;
    }

    public void setIncomeDocumentId(int incomeDocumentId) {
        this.incomeDocumentId = incomeDocumentId;
    }
}
