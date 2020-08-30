package com.hotaru.database.entities;

import com.hotaru.business.enums.DeliveryType;
import com.hotaru.business.enums.OrderState;
import com.hotaru.business.logic.objects.Price;
import com.hotaru.core.database.Identifiable;
import com.hotaru.core.util.container.CustomContainer;
import com.hotaru.database.converters.CustomContainerJsonConverter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "packOrder")
@Entity(name = "packOrder")
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

    @Column(name = "deliveryType", length = 13)
    private DeliveryType deliveryType;

    @Column(name = "orderState", length = 10)
    private OrderState orderState;

    @Column(name = "address", length = 400)
    private String address;

    @Column(name = "additionalInfo", length = 4000)
    private String additionalInfo;

    @Column(name = "price", length = 8)
    private int price;

    @Column(name = "deliveryPrices")
    @Convert(converter = CustomContainerJsonConverter.class)
    private CustomContainer<Price> deliveryPrices;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CustomContainer<Price> getDeliveryPrices() {
        return deliveryPrices;
    }

    public void setDeliveryPrices(CustomContainer<Price> deliveryPrices) {
        this.deliveryPrices = deliveryPrices;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
