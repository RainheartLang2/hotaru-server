package com.hotaru.core.database;

import org.hibernate.Session;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class ResourceBase<E extends Identifiable> {

    protected Class daoClass;
    private E serviceInstance;

    public ResourceBase() {
        this.daoClass = ((Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
        try {
            this.serviceInstance = (E) this.daoClass.getConstructor(new Class[]{}).newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Instance of " + daoClass.getName() + " failed to be instantiated", e);
        }
    }

    public E getById(int id) {
        return (E) getSession().get(this.daoClass, id);
    }

    public List<E> getAll() {
        return getSession().createCriteria(daoClass).list();
    }

    public void saveOrUpdate(E dao) {
        getSession().saveOrUpdate(dao);
    }

    public void delete(int id) {
        this.serviceInstance.setId(id);
        getSession().delete(this.serviceInstance);
    }

    protected Session getSession() {
        return SessionFactoryHolder.getSession();
    }
}
