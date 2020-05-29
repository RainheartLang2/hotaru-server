package com.hotaru.rpc.client;

import com.hotaru.business.managers.PetManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Client;
import com.hotaru.database.entities.Clinic;
import com.hotaru.database.entities.Pet;
import com.hotaru.database.resources.ClientInfoResource;

import java.util.List;

public class ClientService {

    private class ClientInfo {
        private List<Client> clients;
        private List<Pet> pets;

        public ClientInfo(List<Client> clients, List<Pet> pets) {
            this.clients = clients;
            this.pets = pets;
        }

        public List<Client> getClients() {
            return clients;
        }

        public void setClients(List<Client> clients) {
            this.clients = clients;
        }

        public List<Pet> getPets() {
            return pets;
        }

        public void setPets(List<Pet> pets) {
            this.pets = pets;
        }
    }

    public ClientInfo getAll(Integer... ids) {
        List<Client> clients = ClientInfoResource.getInstance().getByIds(List.of(ids));
        List<Pet> pets = PetManager.getInstance().getListByClients(clients);
        return new ClientInfo(clients, pets);
    }

    public ClientInfo getAllPermanent() {
        List<Client> clients = ClientInfoResource.getInstance().getAllPermanent();
        List<Pet> pets = PetManager.getInstance().getListByClients(clients);
        return new ClientInfo(clients, pets);
    }

    public int add(Client client) throws ValidationException {
        ClientInfoResource.getInstance().saveOrUpdate(client);
        return client.getId();
    }

    public void update(Client client) throws ValidationException {
        ClientInfoResource.getInstance().saveOrUpdate(client);
    }

    public void delete(int id) {
        ClientInfoResource.getInstance().markDeleted(id);
    }
}
