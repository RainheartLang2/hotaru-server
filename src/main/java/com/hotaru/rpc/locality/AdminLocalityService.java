package com.hotaru.rpc.locality;

import com.hotaru.business.validation.LocalityValidationForm;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Locality;
import com.hotaru.database.resources.LocalityResource;

public class AdminLocalityService extends UserLocalityService {
    public int add(Locality locality) throws ValidationException {
        if (locality.getId() != 0) {
            throw new ValidationException("id добавляемого пункта обязан быть 0 или null");
        }
        LocalityValidationForm.INSTANCE.validate(locality);
        LocalityResource.getInstance().saveOrUpdate(locality);
        return locality.getId();
    }

    public void update(Locality locality) throws ValidationException {
        if (locality.getId() == 0) {
            throw new ValidationException("id редактируемого пункта не может быть 0 или null");
        }
        LocalityValidationForm.INSTANCE.validate(locality);
        LocalityResource.getInstance().saveOrUpdate(locality);
    }
}
