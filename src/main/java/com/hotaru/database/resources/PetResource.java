package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Pet;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.List;

public class PetResource extends ArchivableResourceBase<Pet> {

    private static PetResource INSTANCE = new PetResource();

    public static PetResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PetResource();
        }
        return INSTANCE;
    }

    public List<Pet> getByOwnerIds(Collection<Integer> ids) {
        return getSession().
                createCriteria(Pet.class)
                .add(Restrictions.in("ownerId", ids))
                .list();
    }

    private PetResource() {
        super();
    }
}
