package com.hotaru.rpc.species;

import com.hotaru.business.managers.SpeciesManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Species;
import com.hotaru.database.resources.SpeciesResource;
import com.hotaru.rest.validation.forms.SpeciesValidationForm;

import java.util.List;

public class SpeciesService {
    public List<Species> getAll() {
        return SpeciesResource.getInstance().getAllNotDeleted();
    }

    public int add(Species species) throws ValidationException {
        SpeciesValidationForm.INSTANCE.validate(species);
        SpeciesManager.getInstance().addSpecies(species);
        return species.getId();
    }

    public void update(Species species) throws ValidationException {
        SpeciesValidationForm.INSTANCE.validate(species);
        SpeciesManager.getInstance().updateSpeces(species);
    }

    public void delete(int id) {
        SpeciesResource.getInstance().markDeleted(id);
    }
}
