package com.hotaru.rpc.client;

import com.hotaru.database.entities.Client;
import com.hotaru.database.resources.ClientInfoResource;

import java.util.List;

public class ClientService {
    public List<Client> getAll(Integer... ids) {
        return ClientInfoResource.getInstance().getByIds(List.of(ids));
    }
}
