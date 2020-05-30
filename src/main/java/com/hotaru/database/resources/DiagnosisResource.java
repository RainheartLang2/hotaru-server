package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Diagnosis;

public class DiagnosisResource extends ArchivableResourceBase<Diagnosis> {
    private static DiagnosisResource INSTANCE = new DiagnosisResource();

    public static DiagnosisResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DiagnosisResource();
        }
        return INSTANCE;
    }

    private DiagnosisResource() {
        super();
    }
}
