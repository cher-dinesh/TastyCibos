package com.tc.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import com.tc.daoimpl.OrderTableDAOImp;
import com.tc.model.Cart;
import com.tc.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	String paymentMethod=request.getParameter("paymentMethod");
    	float payableAmount = Float.parseFloat(request.getParameter("payableAmount"));

        HttpSession session = request.getSession();
        String restaurantId =(String)session.getAttribute("restaurantid");

        User user=(User)session.getAttribute("loggedInUser");
        
        Map<Integer, Cart> map =(Map<Integer, Cart>) session.getAttribute("cartItems");
        Collection<Cart> cartItems=map.values();
        
        OrderTableDAOImp orderTableDAO=new OrderTableDAOImp();
        orderTableDAO.insertOrderDetails(user.getUserId(), Integer.parseInt(restaurantId),"Delivered", payableAmount,cartItems,paymentMethod);

        session.setAttribute("cartItems",null);
        session.setAttribute("quantity", 0);

        response.sendRedirect("checkout.jsp");
    }

}
