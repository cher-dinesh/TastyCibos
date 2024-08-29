package com.tc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.tc.daoimpl.UserDAOImp;
import com.tc.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		HttpSession session=request.getSession();

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email);
		UserDAOImp userDAOImp=new UserDAOImp();

		User user=userDAOImp.getUserByEmail(email,password);
		if(user!=null) {
			writer.println("login Success!");
			session.setAttribute("loggedInUser", user);
			response.sendRedirect("home");
		}else {
			writer.println("failed to login!");
		}


	}

}
