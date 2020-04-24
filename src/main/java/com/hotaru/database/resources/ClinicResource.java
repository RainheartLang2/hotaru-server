package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Clinic;

public class ClinicResource extends ArchivableResourceBase<Clinic> {
    private static ClinicResource INSTANCE = new ClinicResource();

    public static ClinicResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClinicResource();
        }
        return INSTANCE;
    }

    private ClinicResource() {
        super();
    }
}
