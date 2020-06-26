package com.hotaru.rpc.plannedCall;

import com.hotaru.business.logic.enums.PlannedCallState;
import com.hotaru.business.managers.EmployeeManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.entities.PlannedCall;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;
import com.hotaru.database.resources.PlannedCallResource;
import com.hotaru.rest.validation.forms.EmployeeValidationForm;

import java.util.List;

public class PlannedCallService {

    public List<PlannedCall> getAll() {
        return PlannedCallResource.getInstance().getAll();
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
        call.setState(PlannedCallState.Done);
        resource.saveOrUpdate(call);
    }

    public void cancel(int id) {
        PlannedCallResource resource = PlannedCallResource.getInstance();
        PlannedCall call = resource.getById(id);
        call.setState(PlannedCallState.Canceled);
        resource.saveOrUpdate(call);
    }
}
