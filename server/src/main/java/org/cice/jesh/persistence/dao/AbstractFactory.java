package org.cice.jesh.persistence.dao;

import org.cice.jesh.utils.ConnectionUtil;
import org.hibernate.*;
import org.hibernate.Query;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;


/**
 * Created by toni on 20/04/16.
 */
@SuppressWarnings(value = "unchecked")
public abstract class AbstractFactory<DtoType> {

    static final Logger logger = LogManager.getLogger(AbstractFactory.class.getName());
    private final Class<DtoType> dtoType;

    protected AbstractFactory(Class<DtoType> clazz) {
        this.dtoType = clazz;
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
        DtoType result = null;

        try {
            Query query = session.createQuery("FROM " + dtoType.getSimpleName() + " WHERE " + columnToSearch + " =  :str").setString("str", valueToSearch);
            result = (DtoType) query.uniqueResult();

        } catch (HibernateException e) {
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }


        return result;
    }

    protected DtoType findByColumnName(String columnToSearch, int valueToSearch) {

        Session session = ConnectionUtil.getSession();
        DtoType result = null;

        try {
            Query query = session.createQuery("FROM " + dtoType.getSimpleName() + " WHERE " + columnToSearch + " =  :int").setInteger("int", valueToSearch);
            result = (DtoType) query.uniqueResult();

        } catch (HibernateException e) {
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }


        return result;
    }

    protected List<DtoType> findListByString(String columnToSearch, String valueToSearch) {

        Session session = ConnectionUtil.getSession();
        List<DtoType> result = null;

        try {
            Query query = session.createQuery("FROM " + dtoType.getSimpleName() + " WHERE " + columnToSearch + " LIKE  :str").setString("str", "%" + valueToSearch + "%");
            result = query.list();

        } catch (HibernateException e) {
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return result;
    }

    protected List<DtoType> findListByInteger(String columnToSearch, int valueToSearch) {

        Session session = ConnectionUtil.getSession();
        List<DtoType> result = null;

        try {
            Query query = session.createQuery("FROM " + dtoType.getSimpleName() + " WHERE " + columnToSearch + " = :int").setInteger("int", valueToSearch);
            result = query.list();

        } catch (HibernateException e) {
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return result;
    }

    protected List<Object[]> findTop(String table, String column, int limit) {

        Session session = ConnectionUtil.getSession();
        List<Object[]> result = null;

        try {
            Query query = session.createSQLQuery("SELECT " + column + ", COUNT(" + column + ") FROM " + table + " GROUP BY " + column + " ORDER BY COUNT(" + column + ") DESC").setMaxResults(limit);
            result = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        return result;
    }

}
