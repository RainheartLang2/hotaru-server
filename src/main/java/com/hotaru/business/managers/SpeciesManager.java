package com.hotaru.business.managers;

import com.hotaru.database.entities.Species;
import com.hotaru.database.resources.SpeciesResource;

public class SpeciesManager {
    private static SpeciesManager INSTANCE = new SpeciesManager();

    public static SpeciesManager getInstance() {
        return INSTANCE;
    }

    private SpeciesManager() {}

    public void addSpecies(Species species) {
        SpeciesResource.getInstance().saveOrUpdate(species);
    }

    public void updateSpeces(Species species) {
        SpeciesResource.getInstance().saveOrUpdate(species);
    }
}
