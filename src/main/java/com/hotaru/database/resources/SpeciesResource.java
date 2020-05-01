package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Species;

public class SpeciesResource extends ArchivableResourceBase<Species> {
    private static SpeciesResource INSTANCE = new SpeciesResource();

    public static SpeciesResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SpeciesResource();
        }
        return INSTANCE;
    }

    private SpeciesResource() {
        super();
    }
}
