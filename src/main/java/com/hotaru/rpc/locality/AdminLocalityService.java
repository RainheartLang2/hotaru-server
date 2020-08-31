package com.hotaru.rpc.locality;

import com.hotaru.database.entities.Locality;
import com.hotaru.database.resources.LocalityResource;

public class AdminLocalityService extends UserLocalityService {
    public int add(Locality locality) {
        LocalityResource.getInstance().saveOrUpdate(locality);
        return locality.getId();
    }

    public void update(Locality locality) {
        LocalityResource.getInstance().saveOrUpdate(locality);
    }
}
