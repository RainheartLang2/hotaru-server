package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.PlannedCall;

public class PlannedCallResource extends ResourceBase<PlannedCall> {

    private static PlannedCallResource INSTANCE = new PlannedCallResource();

    public static PlannedCallResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlannedCallResource();
        }
        return INSTANCE;
    }
}
