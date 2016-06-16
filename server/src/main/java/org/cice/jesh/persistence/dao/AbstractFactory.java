package org.cice.jesh.persistence.dao;

import org.cice.jesh.utils.ConnectionUtil;
import org.hibernate.*;
import org.hibernate.Query;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by toni on 20/04/16.
 */
public abstract class AbstractFactory<DtoType> {
    
    static final Logger logger = LogManager.getLogger(AbstractFactory.class.getName());
    private final Class<DtoType> dtoType;

    protected AbstractFactory(Class<DtoType> clazz) {
        dtoType = clazz;
    }

    protected List<DtoType> findAll() {
        
        Session session = ConnectionUtil.getSession();
        List<DtoType> arrayList = null;        
        logger.info("Find all from: " + dtoType.getSimpleName() + " class");
        
        try {

            Query query = session.createQuery("FROM " + dtoType.getSimpleName());
            arrayList = query.list();

        } catch (HibernateException e) {
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return arrayList;

    }

    protected DtoType get(Integer id) {
        
        Session session = ConnectionUtil.getSession();
        DtoType newDto = null;
        
        logger.info("Get from: " + dtoType.getSimpleName() + " class");

        try {
            newDto = session.get(dtoType, id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return newDto;
    }

    protected DtoType create(DtoType dto) {
        
        Session session = ConnectionUtil.getSession();
        Transaction tx = null;

        logger.info("Create from: " + dtoType.getSimpleName() + " class");
        
        try {
            tx = session.beginTransaction();

            session.save(dto);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return dto;
    }

    protected DtoType update(DtoType dto) {
        
        Session session = ConnectionUtil.getSession();
        Transaction tx = null;

        logger.info("Update from: " + dtoType.getSimpleName() + " class");
        
        try {
            tx = session.beginTransaction();
            session.merge(dto);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return dto;
    }

    protected void delete(DtoType dto) {
        
        Session session = ConnectionUtil.getSession();
        Transaction tx = null;

        logger.info("Delete from: " + dtoType.getSimpleName() + " class");
        
        try {
            tx = session.beginTransaction();
            session.delete(dto);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }
    }

    protected DtoType findByColumnName(String columnToSearch, String valueToSearch) {
        
        Session session = ConnectionUtil.getSession();        
        
        Query query = session.createQuery("FROM " + dtoType.getSimpleName() + " WHERE " + columnToSearch + " =  :str").setString("str", valueToSearch);
        DtoType queryDtoType = (DtoType) query.uniqueResult();
        
        return queryDtoType;
    }
    
    protected DtoType findByColumnName(String columnToSearch, int valueToSearch) {
        
        Session session = ConnectionUtil.getSession();        
        
        Query query = session.createQuery("FROM " + dtoType.getSimpleName() + " WHERE " + columnToSearch + " =  :int").setInteger("int", valueToSearch);
        DtoType queryDtoType = (DtoType) query.uniqueResult();
        
        return queryDtoType;
    }
    
    @SuppressWarnings("empty-statement")
    protected List<DtoType> find(String columnToSearch, String valueToSearch){        
        
        Session session = ConnectionUtil.getSession();
        Query query = session.createQuery("FROM " + dtoType.getSimpleName() + " WHERE " + columnToSearch + " LIKE  :str").setString("str", "%"+valueToSearch+"%");
        return query.list();
    }

}
