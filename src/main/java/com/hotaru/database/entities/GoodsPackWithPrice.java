package com.hotaru.database.entities;

public class GoodsPackWithPrice extends GoodsPack {

    private int price;
    private double taxRate;

    public GoodsPackWithPrice() {}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
