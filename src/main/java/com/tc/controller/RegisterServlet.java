package com.tc.controller;

import java.io.IOException;

import com.tc.daoimpl.UserDAOImp;
import com.tc.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phonenumber");
        String password = request.getParameter("password");
        String cPassword = request.getParameter("cpassword");
        String address = request.getParameter("address");

        UserDAOImp userDAOImp = new UserDAOImp();

        if (userDAOImp.getUserByEmail(email) == 1) {
            request.setAttribute("message", "This Email is already registered");
        } else {
            if (userName != null && email != null && phoneNumber != null && password.equals(cPassword)) {
                User user = new User(userName, email, phoneNumber, password, address);
                userDAOImp.addUser(user);
                request.setAttribute("message", "Registration Successful");
            } else {
                request.setAttribute("message", "Please enter all details to Register");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
        dispatcher.forward(request, response);
    }
}
