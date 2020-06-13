package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.ClinicScheduleDeviation;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClinicScheduleDeviationResource extends ResourceBase<ClinicScheduleDeviation> {
    private static ClinicScheduleDeviationResource INSTANCE = new ClinicScheduleDeviationResource();

    public static ClinicScheduleDeviationResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClinicScheduleDeviationResource();
        }
        return INSTANCE;
    }

    public List<ClinicScheduleDeviation> getByWorkScheduleId(List<Integer> workScheduleIds) {
        return getSession().
                createCriteria(ClinicScheduleDeviation.class)
                .add(Restrictions.in("workScheduleId", workScheduleIds))
                .list();
    }

    public ClinicScheduleDeviation getByWorkScheduleId(Integer workScheduleId) {
        return (ClinicScheduleDeviation) getSession().
                createCriteria(ClinicScheduleDeviation.class)
                .add(Restrictions.eq("workScheduleId", workScheduleId))
                .uniqueResult();
    }

}
