package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Client;

public class ClientInfoResource extends ArchivableResourceBase<Client> {

    private static ClientInfoResource INSTANCE = new ClientInfoResource();

    public static ClientInfoResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClientInfoResource();
        }
        return INSTANCE;
    }

    private ClientInfoResource() {
        super();
    }
}
