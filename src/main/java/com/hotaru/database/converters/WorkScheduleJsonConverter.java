package com.hotaru.database.converters;

import com.hotaru.core.entities.WorkSchedule;

public class WorkScheduleJsonConverter extends DataBaseJsonConverter<WorkSchedule> {
    @Override
    protected Class<WorkSchedule> getEntityClass() {
        return WorkSchedule.class;
    }
}
