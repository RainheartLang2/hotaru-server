package com.hotaru.business.managers;

import com.hotaru.database.entities.Client;
import com.hotaru.database.entities.Pet;
import com.hotaru.database.resources.PetResource;

import java.util.List;
import java.util.stream.Collectors;

public class PetManager {
    private static PetManager INSTANCE = new PetManager();

    public static PetManager getInstance() {
        return INSTANCE;
    }

    private PetManager() {}

    public List<Pet> getListByClients(List<Client> clients) {
        return PetResource
                .getInstance()
                .getByOwnerIds(clients.stream()
                        .map(client -> client.getId())
                        .collect(Collectors.toList()));
    }

    public int addPet(Pet pet) {
        PetResource.getInstance().saveOrUpdate(pet);
        return pet.getId();
    }

    public void updatePet(Pet pet) {
        PetResource.getInstance().saveOrUpdate(pet);
    }

    public void deletePet(int id) {
        PetResource.getInstance().markDeleted(id);
    }

    public List<Pet> getByClientId(int clientId) {
        return PetResource.getInstance().getByOwnerId(clientId);
    }
}
