package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Locality;

public class LocalityResource extends ResourceBase<Locality> {
    private static LocalityResource INSTANCE = new LocalityResource();

    public static LocalityResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalityResource();
        }
        return INSTANCE;
    }
}
