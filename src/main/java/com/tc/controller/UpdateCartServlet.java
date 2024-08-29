package com.tc.controller;

import java.io.IOException;
import java.util.Map;

import com.tc.daoimpl.CartDAOImp;
import com.tc.daoimpl.MenuDAOImp;
import com.tc.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatecart")
public class UpdateCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action=request.getParameter("action");
		int menuId=Integer.parseInt(request.getParameter("menuid"));

		MenuDAOImp menuDAO=new MenuDAOImp();
		float price=menuDAO.getPriceByMenuId(menuId);

		CartDAOImp cartDAO=new CartDAOImp();
		Map<Integer, Cart> cartItems = (Map<Integer, Cart>) session.getAttribute("cartItems");
		if(action.equals("add")) {
			cartDAO.updateAddItem(cartItems, menuId, price);
		}else if(action.equals("remove")) {
			cartDAO.removeItemFromCart(cartItems, menuId);
		}


        session.setAttribute("cartItems", cartItems);

        int totalQuantity = cartDAO.getTotalQuantity(cartItems);
        session.setAttribute("quantity", totalQuantity);

        request.getRequestDispatcher("cart").forward(request, response);
	}


}
