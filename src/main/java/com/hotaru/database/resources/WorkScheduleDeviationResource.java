package com.hotaru.database.resources;

import com.hotaru.business.logic.enums.DeviationType;
import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.WorkScheduleDeviationContainer;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class WorkScheduleDeviationResource extends ResourceBase<WorkScheduleDeviationContainer> {
    private static WorkScheduleDeviationResource INSTANCE = new WorkScheduleDeviationResource();

    public static WorkScheduleDeviationResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorkScheduleDeviationResource();
        }
        return INSTANCE;
    }

    public List<WorkScheduleDeviationContainer> getByWorkScheduleId(DeviationType type, List<Integer> workScheduleIds) {
        return getSession().
                createCriteria(WorkScheduleDeviationContainer.class)
                .add(Restrictions.in("workScheduleId", workScheduleIds))
                .add(Restrictions.eq("type", type))
                .list();
    }

    public WorkScheduleDeviationContainer getByWorkScheduleId(Integer workScheduleId) {
        return (WorkScheduleDeviationContainer) getSession().
                createCriteria(WorkScheduleDeviationContainer.class)
                .add(Restrictions.eq("workScheduleId", workScheduleId))
                .uniqueResult();
    }

}
