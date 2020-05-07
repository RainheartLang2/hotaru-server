package com.hotaru.rpc.client;

import com.hotaru.database.entities.Pet;
import com.hotaru.database.entities.Client;
import com.hotaru.database.resources.PetResource;
import com.hotaru.database.resources.ClientInfoResource;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Pet> pets = PetResource
                .getInstance()
                .getByOwnerIds(clients.stream()
                                .map(client -> client.getId())
                                .collect(Collectors.toList()));
        return new ClientInfo(clients, pets);
    }
}
