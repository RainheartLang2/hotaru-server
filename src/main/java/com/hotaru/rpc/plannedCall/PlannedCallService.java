package com.hotaru.rpc.plannedCall;

import com.hotaru.business.logic.enums.PlannedCallStateType;
import com.hotaru.business.managers.PlannedCallManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.PlannedCall;
import com.hotaru.database.resources.PlannedCallResource;

import java.util.List;

public class PlannedCallService {

    public List<PlannedCall> getAll() {
        return PlannedCallManager.getInstance().getAll();
    }

    public int add(PlannedCall call) throws ValidationException {
        PlannedCallResource.getInstance().saveOrUpdate(call);
        return call.getId();
    }

    public void update(PlannedCall call) throws ValidationException {
        PlannedCallResource.getInstance().saveOrUpdate(call);
    }

    public void delete(int id) {
        PlannedCallResource.getInstance().delete(id);
    }

    public void markDone(int id) {
        PlannedCallResource resource = PlannedCallResource.getInstance();
        PlannedCall call = resource.getById(id);
        call.setState(PlannedCallStateType.Done);
        resource.saveOrUpdate(call);
    }

    public void cancel(int id) {
        PlannedCallResource resource = PlannedCallResource.getInstance();
        PlannedCall call = resource.getById(id);
        call.setState(PlannedCallStateType.Canceled);
        resource.saveOrUpdate(call);
    }
}
