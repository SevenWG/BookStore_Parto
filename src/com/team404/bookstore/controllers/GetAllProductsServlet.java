package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.CategoryEntity;
import com.team404.bookstore.service.ProductCatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetAllProductsServlet")
/*
    Calls this servlet to get all products and categories list
 */
public class GetAllProductsServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //call service method getProductList (): gets the list of
        //all products if no category is specified
        //In this case, categoryid is not specified, we should provide all products
        ProductCatalogService productCatalogService = new ProductCatalogService();
        List<BookEntity> bookList = productCatalogService.getProductList();
        //call service method getCategoryList(): gets the list of product categories for the store
        List<CategoryEntity> categories = productCatalogService.getCategoryList();
        HttpSession hs = request.getSession();
        hs.setAttribute("allbooks", bookList);
        hs.setAttribute("categories", categories);
        response.sendRedirect("/pages/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
