package com.hotaru.business.managers;

import com.hotaru.business.logic.enums.PlannedCallStateType;
import com.hotaru.database.entities.PlannedCall;
import com.hotaru.database.resources.PlannedCallResource;
import com.hotaru.utils.DateHelper;

import java.util.Date;
import java.util.List;

public class PlannedCallManager {

    private static PlannedCallManager INSTANCE = new PlannedCallManager();

    public static PlannedCallManager getInstance() {
        return INSTANCE;
    }

    private PlannedCallManager() {}

    private void checkCalls(List<PlannedCall> calls) {
        Date currentDate = DateHelper.getCurrentDate();
        for (PlannedCall call: calls) {
            if (call.getState() == PlannedCallStateType.Assigned && call.getCallDate().before(currentDate)) {
                call.setState(PlannedCallStateType.Expired);
                PlannedCallResource.getInstance().saveOrUpdate(call);
            }
        }
    }

    public List<PlannedCall> getAll() {
        List<PlannedCall> result = PlannedCallResource.getInstance().getAll();
        checkCalls(result);
        return result;
    }
}
