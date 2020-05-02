package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Breed;

public class BreedResource  extends ArchivableResourceBase<Breed> {
    private static BreedResource INSTANCE = new BreedResource();

    public static BreedResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BreedResource();
        }
        return INSTANCE;
    }

    private BreedResource() {
    }
}
