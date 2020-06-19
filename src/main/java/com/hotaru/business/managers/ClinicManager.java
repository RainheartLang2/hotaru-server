package com.hotaru.business.managers;

import com.hotaru.core.entities.DaySchedule;
import com.hotaru.core.entities.WorkSchedule;
import com.hotaru.core.util.CollectionUtils;
import com.hotaru.database.entities.Clinic;
import com.hotaru.database.entities.ClinicWorkSchedule;
import com.hotaru.database.resources.ClinicResource;
import com.hotaru.database.resources.ClinicWorkScheduleResource;

public class ClinicManager {
    private static ClinicManager INSTANCE = new ClinicManager();

    private static int DEFAULT_WORK_SCHEDULE_LENGTH = 7;
    private static DaySchedule DEFAULT_DAY_SCHEDULE = new DaySchedule();

    public static ClinicManager getInstance() {
        return INSTANCE;
    }

    private ClinicManager() {}

    public void addClinic(Clinic clinic) {
        ClinicResource.getInstance().saveOrUpdate(clinic);
        ClinicWorkSchedule clinicWorkSchedule = new ClinicWorkSchedule(clinic.getId(),
                false,
                true,
                new WorkSchedule(DEFAULT_WORK_SCHEDULE_LENGTH,
                        true,
                        CollectionUtils.fillArray(DEFAULT_WORK_SCHEDULE_LENGTH, DEFAULT_DAY_SCHEDULE)));
        ClinicWorkScheduleResource.getInstance().saveOrUpdate(clinicWorkSchedule);
    }
}
