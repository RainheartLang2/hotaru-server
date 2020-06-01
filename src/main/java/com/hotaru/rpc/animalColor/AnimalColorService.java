package com.hotaru.rpc.animalColor;

import com.hotaru.database.entities.AnimalColor;
import com.hotaru.database.resources.AnimalColorResource;

import java.util.List;

public class AnimalColorService {
    public List<AnimalColor> getAll() {
        return AnimalColorResource.getInstance().getAllNotDeleted();
    }

    public int add(AnimalColor animalCOlor) {
        AnimalColorResource.getInstance().saveOrUpdate(animalCOlor);
        return animalCOlor.getId();
    }

    public void update(AnimalColor animalColor) {
        AnimalColorResource.getInstance().saveOrUpdate(animalColor);
    }

    public void delete(int id) {
        AnimalColorResource.getInstance().markDeleted(id);
    }
}
