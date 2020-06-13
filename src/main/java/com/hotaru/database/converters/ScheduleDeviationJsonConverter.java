package com.hotaru.database.converters;

import com.hotaru.core.entities.WorkScheduleDeviation;

public class ScheduleDeviationJsonConverter extends DataBaseJsonConverter<WorkScheduleDeviation> {
    @Override
    protected Class<WorkScheduleDeviation> getEntityClass() {
        return WorkScheduleDeviation.class;
    }
}
