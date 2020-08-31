package com.hotaru.business.logic.objects;

public class Price {
    private int from;
    private Integer to;
    private int value;

    public Price(int from, Integer to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public Price() {}

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
