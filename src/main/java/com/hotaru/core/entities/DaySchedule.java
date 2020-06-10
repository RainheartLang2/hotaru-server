package com.hotaru.core.entities;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private List<TimeRange> records;

    public DaySchedule() {
        this.records = new ArrayList<>();
    }

    public DaySchedule(List<TimeRange> records) {
        this.records = records;
    }

    public List<TimeRange> getRecords() {
        return records;
    }

    public void setRecords(List<TimeRange> records) {
        this.records = records;
    }
}
