package com.hotaru.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hotaru.business.logic.enums.DocumentState;
import com.hotaru.business.logic.enums.ShipingType;
import com.hotaru.core.database.Identifiable;
import com.hotaru.core.util.container.CustomContainer;
import com.hotaru.database.converters.CustomContainerJsonConverter;
import com.hotaru.database.converters.GoodsWithPriceJsonConverter;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name="goodsDocument")
@Entity(name="goodsDocument")
public class GoodsDocument implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="documentState", length = 8)
    @NotNull
    private DocumentState documentState;

    @Column(name="shipingType", length = 7)
    @NotNull
    private ShipingType shipingType;

    @Column(name="date")
    @NotNull
    private Date date;

    @Column(name="stockId")
    @NotNull
    private int stockId;

    @Column(name="counterAgentId")
    @NotNull
    private int counterAgentId;

    @Column(name="num")
    private String num;

    @Column(name="goods")
    @Convert(converter = CustomContainerJsonConverter.class)
    private CustomContainer<GoodsPackWithPrice> goods;

    public GoodsDocument() {}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public ShipingType getShipingType() {
        return shipingType;
    }

    public void setShipingType(ShipingType shipingType) {
        this.shipingType = shipingType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getCounterAgentId() {
        return counterAgentId;
    }

    public void setCounterAgentId(int counterAgentId) {
        this.counterAgentId = counterAgentId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public CustomContainer<GoodsPackWithPrice> getGoods() {
        return goods;
    }

    public void setGoods(CustomContainer<GoodsPackWithPrice> goods) {
        this.goods = goods;
    }
}
