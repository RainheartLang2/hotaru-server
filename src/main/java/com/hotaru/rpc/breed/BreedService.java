package com.hotaru.rpc.breed;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Breed;
import com.hotaru.database.resources.BreedResource;
import com.hotaru.rest.validation.forms.BreedValidationForm;

import java.util.List;

public class BreedService {
    public List<Breed> getAll() {
        return BreedResource.getInstance().getAllNotDeleted();
    }

    public int add(Breed species) throws ValidationException {
        BreedValidationForm.INSTANCE.validate(species);
        BreedResource.getInstance().saveOrUpdate(species);
        return species.getId();
    }

    public void update(Breed species) throws ValidationException {
        BreedValidationForm.INSTANCE.validate(species);
        BreedResource.getInstance().saveOrUpdate(species);
    }

    public void delete(int id) {
        BreedResource.getInstance().markDeleted(id);
    }
}
