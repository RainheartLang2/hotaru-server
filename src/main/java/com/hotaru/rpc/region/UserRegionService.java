package com.hotaru.rpc.region;

import com.hotaru.database.entities.Region;
import com.hotaru.database.resources.RegionResource;

import java.util.List;

public class UserRegionService {
    public List<Region> getList() {
        return RegionResource.getInstance().getAll();
    }
}
