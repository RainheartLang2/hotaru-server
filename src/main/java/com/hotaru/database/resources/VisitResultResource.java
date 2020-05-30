package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.VisitResult;

public class VisitResultResource extends ArchivableResourceBase<VisitResult> {
    private static VisitResultResource INSTANCE = new VisitResultResource();

    public static VisitResultResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VisitResultResource();
        }
        return INSTANCE;
    }
}
