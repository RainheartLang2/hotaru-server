package com.hotaru.core.entities;

import java.util.List;

public class DaySchedule {
    private List<TimeRange> records;

    public DaySchedule(List<TimeRange> records) {
        this.records = records;
    }

    public List<TimeRange> getRecords() {
        return records;
    }
}
