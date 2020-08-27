package com.hotaru.database.entities;

import com.hotaru.business.enums.DeliveryType;
import com.hotaru.business.enums.OrderState;
import com.hotaru.core.database.Identifiable;

import javax.persistence.*;
import java.util.Date;

@Table(name = "order")
@Entity(name = "order")
public class Order implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "amount", length = 6)
    private int amount;

    @Column(name = "cost", length = 15)
    private int cost;

    @Column(name = "deliveryType", length = 13)
    private DeliveryType deliveryType;

    @Column(name = "orderState", length = 10)
    private OrderState orderState;

    @Column(name = "address", length = 400)
    private String address;

    @Column(name = "distance", length = 5)
    private int distance;

    @Column(name = "creationDate")
    private Date creationDate;

    public Order() {}

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
