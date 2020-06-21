package com.hotaru.database.converters;

import com.hotaru.core.entities.DaySchedule;

public class DayScheduleJsonConverter extends DataBaseJsonConverter<DaySchedule> {
    @Override
    protected Class<DaySchedule> getEntityClass() {
        return DaySchedule.class;
    }
}
