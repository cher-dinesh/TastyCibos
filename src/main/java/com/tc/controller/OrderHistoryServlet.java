package com.tc.controller;

import java.io.IOException;
import java.util.List;

import com.tc.daoimpl.OrderTableDAOImp;
import com.tc.model.OrderHistory;
import com.tc.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/history")
public class OrderHistoryServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("loggedInUser");
		
		OrderTableDAOImp daoImp= new OrderTableDAOImp();
		List<OrderHistory> history=daoImp.getHistory(user.getUserId());
		
		for(OrderHistory hs:history) {
			System.out.println(hs);
		}
		
		session.setAttribute("history", history);
		res.sendRedirect("orderhistory.jsp");
	}

}
