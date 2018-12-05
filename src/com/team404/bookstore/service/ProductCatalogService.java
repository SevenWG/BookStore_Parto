package com.team404.bookstore.service;

import com.team404.bookstore.dao.BookDao;
import com.team404.bookstore.dao.CategoryDao;
import com.team404.bookstore.dao.DaoFactory;
import com.team404.bookstore.dao.DaoFactoryImpl;
import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.CategoryEntity;
import com.team404.bookstore.entity.Entity;

import java.util.List;

public class ProductCatalogService {

    private CategoryDao categoryDao;
    private BookDao bookDao;

    private DaoFactoryImpl daoFactory = DaoFactoryImpl.SingleDaoFactory();

    /* gets the list of product categories for the store */
    public List<CategoryEntity> getCategoryList() {
        categoryDao = new CategoryDao();

        List<CategoryEntity> list = categoryDao.ListCategory();

        return list;
    }

    /*gets the list of products*/
    /*
     * Implementation of Factory Pattern
     * */
    public List<BookEntity> getProductList() {

        List<BookEntity> list = null;

        list = (List<BookEntity>)daoFactory.ListSomethingById("BookDao", "getListById", 0);

        return list;
    }

    /*gets the list of products for a category*/
    /*
     * Implementation of Factory Pattern
     * */
    public List<BookEntity> getProductList(int categoryid) {

        List<BookEntity> list = null;

        list = (List<BookEntity>)daoFactory.
                ListSomethingById("BookDao", "getListById", categoryid);

        return  list;
    }

    /* gets the detailed product information for a product.*/
    /*
     * Implementation of Factory Pattern
     * */
    public BookEntity getProductInfo(String id) {

        BookEntity bookEntity = null;
        boolean flag = false;

        int id_int = Integer.parseInt(id.trim());

        bookEntity = (BookEntity)daoFactory.getEntityById("BookDao", "getEntityById", id_int);

        return  bookEntity;
    }

    /*get the detailed Category info*/
    public CategoryEntity getCategory(int id) {
        categoryDao = new CategoryDao();

        CategoryEntity categoryEntity = categoryDao.getCategoryById(id);

        return categoryEntity;
    }


}
