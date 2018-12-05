package com.team404.bookstore.dao;

import com.team404.bookstore.entity.UserEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao  {

    public int AddUser(UserEntity userEntity) {

        Session session = HibernateConnection.getSession();

        Transaction transaction = null;
        int id = 0;

        try {
            transaction = session.beginTransaction();
            session.save(userEntity);
            transaction.commit();
            id = GetUserbyAccount(userEntity.getUsername()).getId();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public UserEntity GetUserById (int id) {

        Session session = HibernateConnection.getSession();

        Transaction transaction = null;
        UserEntity userEntity = null;

        try {
            transaction = session.beginTransaction();
            userEntity = (UserEntity) session.get(UserEntity.class, id);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  userEntity;
    }

    public UserEntity GetUserbyAccount (String username) {

        Session session = HibernateConnection.getSession();

        Transaction transaction = null;
        UserEntity userEntity = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("GetUserbyAccountQuery");
            query.setParameter("username", username);
            List<UserEntity> list = query.list();
            transaction.commit();
            if(list.size() != 0) {
                userEntity = (UserEntity)list.get(0);
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userEntity;
    }
}