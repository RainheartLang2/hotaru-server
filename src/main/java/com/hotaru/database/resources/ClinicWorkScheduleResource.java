package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.ClinicWorkSchedule;
import org.hibernate.criterion.Restrictions;

public class ClinicWorkScheduleResource extends ResourceBase<ClinicWorkSchedule> {
    private static ClinicWorkScheduleResource INSTANCE = new ClinicWorkScheduleResource();

    public static ClinicWorkScheduleResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClinicWorkScheduleResource();
        }
        return INSTANCE;
    }

    public ClinicWorkSchedule getByClinicId(int clinicId) {
        return (ClinicWorkSchedule) getSession().
                createCriteria(ClinicWorkSchedule.class)
                .add(Restrictions.in("clinicId", clinicId))
                .uniqueResult();
    }

    public ClinicWorkSchedule getDefaultSchedule() {
        return (ClinicWorkSchedule) getSession()
                .createCriteria(ClinicWorkSchedule.class)
                .add(Restrictions.eq("defaultSchedule", true))
                .uniqueResult();
    }


    private ClinicWorkScheduleResource() {
        super();
    }
}
