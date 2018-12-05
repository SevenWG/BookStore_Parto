package com.team404.bookstore.service;

import com.team404.bookstore.dao.*;
import com.team404.bookstore.entity.*;

import java.util.List;

public class OrderProcessService {
    private UserDao userDao;
    private AddressDao addressDao;
    private ShoppingCartDao shoppingCartDao;
    private BookDao bookDao;
    private OrderDao orderDao;
    private OrderBookDao orderBookDao;
    private CountDao countDao;

    private DaoFactoryImpl daoFactory = DaoFactoryImpl.SingleDaoFactory();
    private OrderServiceFacade orderServiceFacade;

    /*Submit Function*/
    public boolean CreateAccount(UserEntity userEntity, AddressEntity addressEntity) {
        boolean flag = true;
        userDao = new UserDao();
        addressDao = new AddressDao();
        UserEntity userEntity1 = userDao.GetUserbyAccount(userEntity.getUsername());

        if(userEntity1 != null) {
            flag = false;
        }
        else {
            int id = userDao.AddUser(userEntity);
            addressEntity.setUserid(id);
            System.out.print(addressEntity.getUserid());
            addressDao.AddAddress(addressEntity);
        }
        return  flag;
    }

    /*Login Verification*/
    public boolean getAccount(UserEntity userEntity) {
        boolean flag = true;
        userDao = new UserDao();

        UserEntity userEntity1 = userDao.GetUserbyAccount(userEntity.getUsername());

        if(userEntity1 != null){
            if(userEntity.getPassword().equals(userEntity1.getPassword())) {
                flag = true;
            } else {
                flag = false;
            }
        } else {

            flag = false;
        }
        return flag;
    }
    /*
        Get UserEntity by username provided
     */
    public UserEntity GetUserByAccount(String username) {
        userDao = new UserDao();

        UserEntity userEntity = userDao.GetUserbyAccount(username);

        return  userEntity;
    }

    /*Personal Info-UserAccount Info*/
    public UserEntity getUserinfo(int id) {
        userDao = new UserDao();

        UserEntity userEntity = userDao.GetUserById(id);

        return userEntity;
    }

    /*Personal Info-Address Info*/
    public AddressEntity getAddressinfo(int userid) {
        addressDao = new AddressDao();

        AddressEntity addressEntity = addressDao.getAddressByUid(userid);

        return addressEntity;
    }

    /*Customer add item(s) to their own shopping cart*/
    public boolean AddItemtoCart(ShoppingCartEntity shoppingCartEntity) {

        shoppingCartDao = new ShoppingCartDao();

        if(shoppingCartDao.GetCartItem(shoppingCartEntity.getUserid(),
                shoppingCartEntity.getBookid()) == null) {
            return shoppingCartDao.AddShoppingCart(shoppingCartEntity);
        }

        else {
            return shoppingCartDao.UpdateItemQuantity(shoppingCartEntity);
        }

    }

    /*Display customers' shopping cart contents*/
    /*
     * Implementation of Factory Pattern
     * */
    public List<ShoppingCartEntity> DisplayShoppingCart(int userid) {
        List<ShoppingCartEntity> list = null;

        list = (List<ShoppingCartEntity>)daoFactory.
                ListSomethingById("ShoppingCartDao", "getListById", userid);

        return  list;
    }

    /*Delete single item in shopping cart*/
    public boolean DeleteSingleItem(int id) {
        shoppingCartDao = new ShoppingCartDao();

        return shoppingCartDao.DeleteShoppingItemById(id);
    }


    /*creates a purchase order including shipping, taxes, total amount due based on shopping cart info*/
    /*We moved the detailed operation into ServiceFace Class*/
    public int createOrder(int userid) {

        orderServiceFacade = new OrderServiceFacade();

        int id = orderServiceFacade.OrderGnerator(userid);

        return id;
    }


    /*Confirm User's Order, Fail every 5th times among every orders*/
    public boolean confirmOrder(int orderid) {
        countDao = new CountDao();
        orderDao = new OrderDao();
        boolean flag = true;

        if(countDao.getCount().getCounts() % 5 == 0 && countDao.getCount().getCounts() >= 5) {
            countDao.CountUpdate();
            flag = false;
            orderDao.UpdateOrderStatus(orderid, flag);
        }else {
            countDao.CountUpdate();
            flag = true;
            orderDao.UpdateOrderStatus(orderid, flag);
        }
        return flag;
    }

    /*My Order Page-Display User's Order List(Should be used with some other functions to display the details)*/
    /*
     * Implementation of Factory Pattern
     * */
    public List<OrderEntity> DisplayMyOrder (int userid) {

        List<OrderEntity> list =
                (List<OrderEntity>)daoFactory.
                        ListSomethingById("OrderDao", "getListById", userid);

        return  list;
    }
    /*
        Get a list of OrderBookEntity based on orderid
     */
    public List<OrderBookEntity> GetOrderBooks (int orderid) {
        orderBookDao = new OrderBookDao();

        return  orderBookDao.GetOrderBookByOid(orderid);
    }
}