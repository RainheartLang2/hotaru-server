package com.hotaru.business.managers;

import com.hotaru.database.entities.Breed;
import com.hotaru.database.resources.BreedResource;

public class BreedManager {
    private static BreedManager INSTANCE = new BreedManager();

    public static BreedManager getInstance() {
        return INSTANCE;
    }

    private BreedManager() {}

    public void addBreed(Breed breed) {
        BreedResource.getInstance().saveOrUpdate(breed);
    }

    public void updateBreed(Breed breed) {
        BreedResource.getInstance().saveOrUpdate(breed);
    }
}
