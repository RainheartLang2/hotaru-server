package com.hotaru.database.resources;

import com.hotaru.business.logic.enums.ClientType;
import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Client;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClientInfoResource extends ArchivableResourceBase<Client> {

    private static ClientInfoResource INSTANCE = new ClientInfoResource();

    public static ClientInfoResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClientInfoResource();
        }
        return INSTANCE;
    }

    public List<Client> getAllPermanent() {
        return getSession().
                createCriteria(daoClass)
                .add(Restrictions.eq("type", ClientType.PERMANENT))
                .list();
    }

    private ClientInfoResource() {
        super();
    }
}
