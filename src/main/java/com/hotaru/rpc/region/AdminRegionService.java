package com.hotaru.rpc.region;

import com.hotaru.database.entities.Region;
import com.hotaru.database.resources.RegionResource;

public class AdminRegionService extends UserRegionService {
    public int add(Region region) {
        RegionResource.getInstance().saveOrUpdate(region);
        return region.getId();
    }

    public void update(Region region) {
        RegionResource.getInstance().saveOrUpdate(region);
    }
}
