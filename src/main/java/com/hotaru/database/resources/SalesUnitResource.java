package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.SalesUnit;

public class SalesUnitResource extends ArchivableResourceBase<SalesUnit> {
    private static SalesUnitResource INSTANCE = new SalesUnitResource();

    public static SalesUnitResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SalesUnitResource();
        }
        return INSTANCE;
    }
}
