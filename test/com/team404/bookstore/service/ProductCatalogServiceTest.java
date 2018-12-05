package com.team404.bookstore.service;

import com.team404.bookstore.entity.BookEntity;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ProductCatalogServiceTest {

    private ProductCatalogService productCatalogService = new ProductCatalogService();
    @Test
    public void getCategoryList() {
        try {
            File file = new File("ProductCatalogServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getCategoryList Function Test: " + productCatalogService.getCategoryList());
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProductList() {

        try {
            File file = new File("ProductCatalogServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getProductList Function Test: " + productCatalogService.getProductList());
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProductList1() {

        try {
            File file = new File("ProductCatalogServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getProductList Function(Rewrite) Test: " + productCatalogService.getProductList(1));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProductInfo() {
        try {
            File file = new File("ProductCatalogServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getProductInfo Function Test: " + productCatalogService.getProductInfo("1118008189"));
            BookEntity bookEntity = (BookEntity)productCatalogService.getProductInfo("1118008189");
            System.out.println(bookEntity.getBookid() + " " + bookEntity.getTitle() + " " +
                    bookEntity.getAuthor() + " " + bookEntity.getPrice());
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCategory() {
        try {
            File file = new File("ProductCatalogServiceTestLog.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintStream print = new PrintStream(new FileOutputStream(file,true));
            System.setOut(print);
            System.out.println("getCategory Function Test: " + productCatalogService.getCategory(1));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}