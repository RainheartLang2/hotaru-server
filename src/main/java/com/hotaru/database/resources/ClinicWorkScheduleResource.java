package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.ClinicWorkSchedule;

public class ClinicWorkScheduleResource extends ResourceBase<ClinicWorkSchedule> {
    private static ClinicWorkScheduleResource INSTANCE = new ClinicWorkScheduleResource();

    public static ClinicWorkScheduleResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClinicWorkScheduleResource();
        }
        return INSTANCE;
    }

    private ClinicWorkScheduleResource() {
        super();
    }
}
