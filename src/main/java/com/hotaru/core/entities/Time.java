package com.hotaru.core.entities;

public class Time {
    private int hours;
    private int minutes;

    public Time() {
    }

    public Time(int hours, int minutes) {
        if (this.hours > 23) {
            throw new IllegalArgumentException("Часы в экземпляре времени не могут превышать 23");
        }
        if (this.hours < 0) {
            throw new IllegalArgumentException("Часы не могут быть отрицательным значением");
        }
        if (this.minutes > 59) {
            throw new IllegalArgumentException("Минуты в экземпляре времени не могут превышать 59");
        }
        if (this.minutes < 0) {
            throw new IllegalArgumentException("Минуты не могут быть отрицательным значением");
        }

        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
