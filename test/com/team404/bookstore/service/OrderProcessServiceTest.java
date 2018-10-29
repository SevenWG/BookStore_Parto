package com.team404.bookstore.service;

import com.team404.bookstore.entity.AddressEntity;
import com.team404.bookstore.entity.ShoppingCartEntity;
import com.team404.bookstore.entity.UserEntity;
import org.hibernate.boot.archive.spi.AbstractArchiveDescriptor;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderProcessServiceTest {

    OrderProcessService orderProcessService = new OrderProcessService();

    public void writeToFile(String str) {
        FileOutputStream fileOutputStream = null;
        byte[] buff = new byte[]{};

        try {
            File file = new File("OrderProcessServiceTestLog.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            buff=str.getBytes();
            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(buff);
            fileOutputStream.flush();
            fileOutputStream.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void createAccount() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("a597217837@hotmail.com");
        userEntity.setPassword("123000");
        userEntity.setFirstname("Nancy");
        userEntity.setLastname("Chen");
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry("Canada"); addressEntity.setProvince("ON");
        addressEntity.setStreet("800 King Edward"); addressEntity.setZip("K1L 5M2");
        addressEntity.setPhone("6132267789");


        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("CreateAccount Function Test: " + orderProcessService.CreateAccount(userEntity,addressEntity));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAccount() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("weiw4180@hotmail.com");
        userEntity.setPassword("123000");
        userEntity.setFirstname("Alex");
        userEntity.setLastname("Wei");

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getAccount Function Test: " + orderProcessService.getAccount(userEntity));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getUserByAccount() {
        UserEntity userEntity = orderProcessService.GetUserByAccount("weiw4180@gmail.com");

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getUserByAccount Function Test: " + userEntity.getId()+" "+userEntity.getUsername()+" ");
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserinfo() {

        UserEntity userEntity = orderProcessService.getUserinfo(2);

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getUserinfo Function Test: " + userEntity.getId()+" "+userEntity.getUsername()+" ");
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAddressinfo() {
        AddressEntity addressEntity = orderProcessService.getAddressinfo(2);

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getAddressinfo Function Test: "+ addressEntity.getId() +  " " + addressEntity.getStreet() + " " + addressEntity.getProvince() + " " +
                    addressEntity.getCountry() + " " + addressEntity.getZip() + addressEntity.getPhone() + " " + addressEntity.getUserid());
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addItemtoCart() {
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setUserid(2);
        shoppingCartEntity.setQuantity(8);
        shoppingCartEntity.setBookid("1627794258");

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("AddItemtoCart Function Test: " + orderProcessService.AddItemtoCart(shoppingCartEntity));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void displayShoppingCart() {
        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("displayShoppingCart Function Test: " + orderProcessService.DisplayShoppingCart(2));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteSingleItem() {
        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("DeleteSingleItem Function Test: " + orderProcessService.DeleteSingleItem(40));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculateAmount() {

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setUserid(2);
        shoppingCartEntity.setQuantity(2);
        shoppingCartEntity.setBookid("1627794334");

        ShoppingCartEntity shoppingCartEntity1 = new ShoppingCartEntity();
        shoppingCartEntity1.setUserid(2);
        shoppingCartEntity1.setQuantity(8);
        shoppingCartEntity1.setBookid("1627794258");

        List<ShoppingCartEntity> list = new ArrayList<>();
        list.add(shoppingCartEntity);list.add(shoppingCartEntity1);

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("CalculateAmount Function Test: " + orderProcessService.CalculateAmount(list));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculateTotalPrice() {

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setUserid(2);
        shoppingCartEntity.setQuantity(2);
        shoppingCartEntity.setBookid("1627794334");

        ShoppingCartEntity shoppingCartEntity1 = new ShoppingCartEntity();
        shoppingCartEntity1.setUserid(2);
        shoppingCartEntity1.setQuantity(8);
        shoppingCartEntity1.setBookid("1627794258");

        List<ShoppingCartEntity> list = new ArrayList<>();
        list.add(shoppingCartEntity);list.add(shoppingCartEntity1);

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("CalculateTotalPrice Function Test: " + orderProcessService.CalculateTotalPrice(list));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getOrderGenerationTime() {
        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("GetOrderGenerationTime Function Test: " + orderProcessService.GetOrderGenerationTime());
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createOrder() {
        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("createOrder Function Test: " + orderProcessService.createOrder(2));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createOrderBook() {
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setUserid(2);
        shoppingCartEntity.setQuantity(2);
        shoppingCartEntity.setBookid("1627794334");

        ShoppingCartEntity shoppingCartEntity1 = new ShoppingCartEntity();
        shoppingCartEntity1.setUserid(2);
        shoppingCartEntity1.setQuantity(8);
        shoppingCartEntity1.setBookid("1627794258");

        List<ShoppingCartEntity> list = new ArrayList<>();
        list.add(shoppingCartEntity);list.add(shoppingCartEntity1);

        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            orderProcessService.createOrderBook(list, 21);
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmOrder() {
        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("confirmOrder Function Test: " + orderProcessService.confirmOrder(21));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void displayMyOrder() {
        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("DisplayMyOrder Function Test: " + orderProcessService.DisplayMyOrder(2));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getOrderBooks() {
        try {
            File file = new File("OrderProcessServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("GetOrderBooks Function Test: " + orderProcessService.GetOrderBooks(21));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}