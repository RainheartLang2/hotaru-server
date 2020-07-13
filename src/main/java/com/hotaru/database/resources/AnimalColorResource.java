package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.AnimalColor;

public class AnimalColorResource extends ArchivableResourceBase<AnimalColor> {
    private static AnimalColorResource INSTANCE = new AnimalColorResource();

    public static AnimalColorResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AnimalColorResource();
        }
        return INSTANCE;
    }

    private AnimalColorResource() {}
}
