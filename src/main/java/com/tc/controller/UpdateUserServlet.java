package com.tc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.tc.daoimpl.UserDAOImp;
import com.tc.model.User;

@WebServlet("/update_profile")
public class UpdateUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("loggedInUser");
		String userName=request.getParameter("username");
		String email=request.getParameter("email");
		String phoneNumber=request.getParameter("phonenumber");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		
		user.setAddress(address);
		user.setUserName(userName);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(password);
		
		UserDAOImp userDAO=new UserDAOImp();
		userDAO.updateUser(user);
		response.sendRedirect("profile.jsp");
	}

}
