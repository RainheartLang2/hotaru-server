package com.hotaru.rpc.locality;

import com.hotaru.database.entities.Locality;
import com.hotaru.database.resources.LocalityResource;

import java.util.List;

public class UserLocalityService {
    public List<Locality> getList() {
        return LocalityResource.getInstance().getAll();
    }
}
