package com.hotaru.rpc.pet;

import com.hotaru.business.managers.PetManager;
import com.hotaru.database.entities.Pet;

import java.util.List;

public class PetService {

    public List<Pet> getForClient(int clientId) {
        return PetManager.getInstance().getByClientId(clientId);
    }

    public int add(Pet pet){
        return PetManager.getInstance().addPet(pet);
    }

    public void update(Pet pet) {
        PetManager.getInstance().updatePet(pet);
    }

    public void delete(int id) {
        PetManager.getInstance().deletePet(id);
    }
}
