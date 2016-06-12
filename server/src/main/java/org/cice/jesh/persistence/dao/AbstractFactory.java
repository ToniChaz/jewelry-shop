package org.cice.jesh.persistence.dao;

import org.cice.jesh.utils.Connexion;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
public abstract class AbstractFactory<DtoType> {

    protected final Class<DtoType> DTO_CLASS;
    protected Session session = Connexion.getSession();


    protected AbstractFactory(Class<DtoType> clazz) {
        this.DTO_CLASS = clazz;
    }

    protected List<DtoType> findAll() {

        List<DtoType> objects = null;
        Transaction tx = session.beginTransaction();

        try {
            Query query = session.createQuery("FROM " + DTO_CLASS.getSimpleName());

            objects = new ArrayList<>();
            for(final Object o : query.list()) {
                objects.add((DtoType)o);
            }

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return objects;

    }

    protected DtoType get(Integer id) {
        return null;
    }

    protected DtoType create(DtoType dto) {

        Transaction tx = session.beginTransaction();

        session.save(dto);
        tx.commit();
        session.close();

        return dto;
    }

    protected DtoType update(DtoType dto) {
        return null;
    }

    protected void delete(Integer userId) {
    }
}
