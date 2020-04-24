package com.hotaru.core.database;

import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ArchivableResourceBase<E extends Identifiable & Archivable> extends ResourceBase<E> {
    public List<E> getAllNotDeleted() {
        return getSession()
                .createCriteria(daoClass)
                .add(Restrictions.eq("deleted", false))
                .list();
    }

    public void markDeleted(int id) {
        E item = this.getById(id);
        item.setDeleted(true);
    }
}
