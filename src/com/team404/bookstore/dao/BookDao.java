package com.team404.bookstore.dao;

import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.Entity;
import com.team404.bookstore.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class BookDao implements DaoFactory{
    private static SessionFactory sessionFactory = HibernateConnection.singleSessionFactiory();

//    public List<BookEntity> ListBook() {
//        List<BookEntity> list = null;
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            list = session.getNamedQuery("ListBookQuery").list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            if (transaction!=null) transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return list;
//    }

//    public List<BookEntity> getEntityList(){
//        List<BookEntity> list = null;
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            list = session.getNamedQuery("ListBookQuery").list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return list;
//    }

//    public List<BookEntity> ListBook(int categoryid) {
//        List<BookEntity> list = null;
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            Query query = session.getNamedQuery("ListBookByCidQuery");
//            query.setParameter("categoryid", categoryid);
//            list = query.list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            if (transaction!=null) transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return list;
//    }

    public List<BookEntity> getListById(int categoryid) {
        List<BookEntity> list = null;
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            if(categoryid != 0)
            {
                transaction = session.beginTransaction();
                Query query = session.getNamedQuery("ListBookByCidQuery");
                query.setParameter("categoryid", categoryid);
                list = query.list();
                transaction.commit();
            }
            else {
                transaction = session.beginTransaction();
                list = session.getNamedQuery("ListBookQuery").list();
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

//    public BookEntity GetBookById(String id) {
//        BookEntity bookEntity = null;
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = null;
//
//        try {
//            transaction = session.beginTransaction();
//            bookEntity= (BookEntity) session.get(BookEntity.class, id);
//            transaction.commit();
//
//        } catch (HibernateException e) {
//            if (transaction!=null) transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return  bookEntity;
//    }

    public BookEntity getEntityById(int id_int) {

        BookEntity bookEntity = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        String id = String.valueOf(id_int);

        System.out.println(id);

        try {
            transaction = session.beginTransaction();
            bookEntity= (BookEntity) session.get(BookEntity.class, id);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  bookEntity;
    }

}