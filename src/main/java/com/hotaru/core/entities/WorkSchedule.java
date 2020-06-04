package com.hotaru.core.entities;

import java.util.Map;

public class WorkSchedule {
    private int length;
    private Map<Integer, DaySchedule> schedule;

    public WorkSchedule(int length, Map<Integer, DaySchedule> schedule) {
        this.length = length;
        this.schedule = schedule;
    }

    public int getLength() {
        return length;
    }

    public Map<Integer, DaySchedule> getSchedule() {
        return schedule;
    }

    public DaySchedule getDaySchedule(int dayNumber) {
        return schedule.get(dayNumber);
    }

    public void setDaySchedule(int dayNumber, DaySchedule daySchedule) {
        schedule.put(dayNumber, daySchedule);
    }
}
