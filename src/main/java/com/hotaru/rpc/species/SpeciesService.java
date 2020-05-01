package com.hotaru.rpc.species;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Species;
import com.hotaru.database.resources.SpeciesResource;
import com.hotaru.rest.validation.forms.SpeciesValidationForm;

import java.util.List;

public class SpeciesService {
    public List<Species> getAll() {
        return SpeciesResource.getInstance().getAllNotDeleted();
    }

    public int add(Species clinic) throws ValidationException {
        SpeciesValidationForm.INSTANCE.validate(clinic);
        SpeciesResource.getInstance().saveOrUpdate(clinic);
        return clinic.getId();
    }

    public void update(Species clinic) throws ValidationException {
        SpeciesValidationForm.INSTANCE.validate(clinic);
        SpeciesResource.getInstance().saveOrUpdate(clinic);
    }

    public void delete(int id) {
        SpeciesResource.getInstance().markDeleted(id);
    }
}
