package com.team404.bookstore.service;

import com.team404.bookstore.entity.*;

import java.lang.reflect.Method;
import java.util.List;

public class ServiceTest {

    public static void main(String args[]) throws Exception{
        UserEntity  userEntity = new UserEntity();
        AddressEntity addressEntity = new AddressEntity();
        OrderProcessService orderProcessService = new OrderProcessService();
        ProductCatalogService productCatalogService = new ProductCatalogService();


/*        userEntity.setUsername("weiw4180@163.com");
        userEntity.setPassword("123123");
        userEntity.setFirstname("Wei");
        userEntity.setLastname("Wei");
        addressEntity.setCountry("Canada"); addressEntity.setProvince("ON");
        addressEntity.setStreet("190 Lees Ave 212"); addressEntity.setZip("K1S 5L5");
        addressEntity.setPhone("17600364180");*/

//        System.out.println(orderProcessService.getUserinfo(10).getUsername());

//        List<CategoryEntity> list = productCatalogService.getCategoryList();
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getId()+" "+list.get(i).getCategory());
//        }

//        List<BookEntity> list = productCatalogService.getProductList(1);
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getBookid() + " " + list.get(i).getTitle() + " " + list.get(i).getCategoryid());
//        }

//        BookEntity bookEntity = productCatalogService.getProductInfo("1627794258");
//        System.out.println(bookEntity.getBookid() + " " + bookEntity.getTitle() + " " + bookEntity. getPrice());
//
//        CategoryEntity categoryEntity = productCatalogService.getCategory(1);
//        System.out.println(categoryEntity.getId() + " " + categoryEntity.getCategory());
////
//        List<Entity> list = orderProcessService.DisplayShoppingCart(4);
//
//        for(int i = 0 ; i <list.size(); i++){
//            ShoppingCartEntity orderEntity = (ShoppingCartEntity) list.get(i);
//            System.out.println(orderEntity.getId()+" "+orderEntity.getUserid()+" "+orderEntity.getBookid());
//        }

//        String className = "com.team404.bookstore.dao.BookDao";
//        String methodName = "getEntityList";
//        Class clz = Class.forName(className);
//        //
//        Object obj = clz.newInstance();
//        System.out.println(obj.getClass().toString());
//
//        Method[] ms = obj.getClass().getMethods();
//        for(int i =0; i < ms.length; i++) {
//            System.out.println(ms[i].getName());
//        }
//
//        Class c = obj.getClass();
//        Method m = c.getDeclaredMethod(methodName);
//        List<Entity> list = (List<Entity>)m.invoke(obj);
//        for(int i = 0 ; i <list.size(); i++){
//            BookEntity bookEntity = (BookEntity)list.get(i);
//            System.out.println(bookEntity.getBookid()+" "+bookEntity.getTitle());
//        }

        //获取方法
//        Method m = obj.getClass().getDeclaredMethod(methodName, String.class);
//
//        List<Entity> list = (List<Entity>)m.invoke(obj,"exceute:"+className+" "+methodName);
//        for(int i = 0 ; i <list.size(); i++){
//            BookEntity bookEntity = (BookEntity)list.get(i);
//            System.out.println(bookEntity.getBookid()+" "+bookEntity.getTitle());
//        }

//        UserEntity userEntity1 = orderProcessService.GetUserByAccount("test@test.com");
////        System.out.println(userEntity1.getUsername());
////
////        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
////        shoppingCartEntity.setBookid("7869656140");
////        shoppingCartEntity.setQuantity(1);
////        shoppingCartEntity.setUserid(1);
////        orderProcessService.AddItemtoCart(shoppingCartEntity);

//        BookEntity bookEntity = productCatalogService.getProductInfo("1627794334");
//        System.out.println(bookEntity.getTitle());

    }
}
