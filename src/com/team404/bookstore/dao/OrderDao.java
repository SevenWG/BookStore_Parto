package com.team404.bookstore.dao;

import com.team404.bookstore.entity.Entity;
import com.team404.bookstore.entity.OrderEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDao implements DaoFactory{

    public int AddOrder (OrderEntity orderEntity) {
        Session session = HibernateConnection.getSession();
        int id = 0;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(orderEntity);
            transaction.commit();
            id = orderEntity.getId();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return id;
    }


    public List<OrderEntity> getListById (int userid) {
        Session session = HibernateConnection.getSession();
        Transaction transaction = null;
        List<OrderEntity> list = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("GetOdersByUidQuery");
            query.setParameter("userid", userid);
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public void UpdateOrderStatus(int id, boolean flag) {
        Session session = HibernateConnection.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("UpdateOrderStatusQuery");
            if(flag) {
                query.setParameter("status", "Success");
            } else {
                query.setParameter("status", "Failed");
            }
            query.setParameter("id", id);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result + " Oid:" +id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    public List<OrderEntity> GetOdersByUid(int userid) {
//        Session session = HibernateConnection.getSession();
//        Transaction transaction = null;
//        List<OrderEntity> list = null;
//
//        try {
//            transaction = session.beginTransaction();
//            Query query = session.getNamedQuery("GetOdersByUidQuery");
//            query.setParameter("userid", userid);
//            list = query.list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return list;
//    }

    public OrderEntity getEntityById (int id) {

        Session session = HibernateConnection.getSession();
        Transaction transaction = null;
        OrderEntity orderEntity = null;

        try {
            transaction = session.beginTransaction();
            orderEntity = (OrderEntity)session.get(OrderEntity.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderEntity;
    }


}
