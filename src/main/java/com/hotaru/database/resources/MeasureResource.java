package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Measure;

public class MeasureResource extends ArchivableResourceBase<Measure> {

    private static MeasureResource INSTANCE = new MeasureResource();

    public static MeasureResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MeasureResource();
        }
        return INSTANCE;
    }
}
