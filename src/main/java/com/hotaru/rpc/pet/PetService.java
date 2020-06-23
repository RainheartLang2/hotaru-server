package com.hotaru.rpc.pet;

import com.hotaru.business.managers.PetManager;
import com.hotaru.database.entities.Pet;

import java.util.List;

public class PetService {

    public List<Pet> getForClient(int clientId) {
        return PetManager.getInstance().getByClientId(clientId);
    }
}
