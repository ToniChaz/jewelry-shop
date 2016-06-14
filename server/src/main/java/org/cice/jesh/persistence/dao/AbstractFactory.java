package org.cice.jesh.persistence.dao;

import org.cice.jesh.utils.Connexion;
import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
public abstract class AbstractFactory<DtoType> {

    protected Session session = Connexion.getSession();
    private final Class<DtoType> dtoType;

    protected AbstractFactory( Class<DtoType> clazz ) {
        dtoType = clazz;
    }

    protected List<DtoType> findAll() {

        List<DtoType> arrayList = null;

        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("FROM " + dtoType.getSimpleName());
            arrayList = query.list();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return arrayList;

    }

    protected DtoType get(Integer id) {
        return null;
    }

    protected DtoType create(DtoType dto) {
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.save(dto);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return dto;
    }

    protected DtoType update(String id, DtoType dto) {

        Transaction tx = session.beginTransaction();

        //DtoType student = session.load(dtoType, id);
        //student.setName("Johnson");
        session.update(id, dto);
        tx.commit();
        session.close();

        return dto;
    }

    protected void delete(Integer userId) {
        /*EntityManager entityManager = emh.getEntityManager();

        entityManager.getTransaction().begin();

        C dto = entityManager.find( dtoClassType, id );
        entityManager.remove(dto);
        entityManager.getTransaction().commit();*/
    }

    protected  boolean checkIfExist(String columnToSearch, String valueToSearch){
        Query query = session.createQuery("SELECT 1 FROM " + dtoType.getSimpleName() + " where " + columnToSearch + "=  :str").setString("str", valueToSearch );
        return (query.uniqueResult() != null);
    }

}
