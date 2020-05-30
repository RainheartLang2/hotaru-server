package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.VisitPurpose;

public class VisitPurposeResource extends ArchivableResourceBase<VisitPurpose> {
    private static VisitPurposeResource INSTANCE = new VisitPurposeResource();

    public static VisitPurposeResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VisitPurposeResource();
        }
        return INSTANCE;
    }
}
