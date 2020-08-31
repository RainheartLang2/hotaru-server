package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Region;

public class RegionResource extends ResourceBase<Region> {
    private static RegionResource INSTANCE = new RegionResource();

    public static RegionResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RegionResource();
        }
        return INSTANCE;
    }
}
