package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.AddressEntity;
import com.team404.bookstore.entity.UserEntity;
import com.team404.bookstore.service.OrderProcessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginAction implements UserAction
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String emailUserName = request.getParameter("email");
        String password = request.getParameter("password");
        /* call getAccount(accountName, accountPassword, accountInfo)
         * service method returns accountInfo if accountName exists
         * and accountPassword is correct, otherwise returns null
         */
        /*
            we should validate email and password in advance
         */
        if (emailUserName != null && emailUserName.length() > 0
                && emailUserName.indexOf("@") > 0
                && emailUserName.indexOf("@") < emailUserName.length() - 1
                && password != null && password.length() >= 6)
        {
            UserEntity u = new UserEntity();
            u.setUsername(emailUserName);
            u.setPassword(password);
            OrderProcessService orderProcessService = new OrderProcessService();

            boolean flag = orderProcessService.getAccount(u);
            HttpSession hs = request.getSession();
            if (!flag)
            {
                //login fail
                response.sendRedirect("/pages/signin.jsp");
            } else
            {
                UserEntity ue = orderProcessService.GetUserByAccount(emailUserName);
                AddressEntity address = orderProcessService.getAddressinfo(ue.getId());
                //login success, put user information and address into the session
                hs.setAttribute("user", ue);
                hs.setAttribute("address", address);
                response.sendRedirect("/pages/index.jsp");
            }
            System.out.println("The login userName and password are valid");
        } else { //invalid email or password
            System.out.println("The login information is invalid");
            response.sendRedirect("/pages/signin.jsp");
        }
    }
}
