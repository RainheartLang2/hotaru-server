package com.hotaru.business.managers;

import com.hotaru.database.entities.Client;
import com.hotaru.database.resources.ClientInfoResource;

public class ClientManager {
    private static ClientManager INSTANCE = new ClientManager();

    public static ClientManager getInstance() {
        return INSTANCE;
    }

    private ClientManager() {}

    public void addClient(Client client) {
        ClientInfoResource.getInstance().saveOrUpdate(client);
    }

    public void updateClient(Client client) {
        ClientInfoResource.getInstance().saveOrUpdate(client);
    }
}
