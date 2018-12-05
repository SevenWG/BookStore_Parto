package com.team404.bookstore.dao;

import java.util.List;

/*
 * Implementation of Factory Pattern
 * */

public interface DaoFactory<T> {

    public List<T> getListById(int id);

    public T getEntityById(int id);

}
