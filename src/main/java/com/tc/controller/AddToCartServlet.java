package com.tc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import com.tc.daoimpl.CartDAOImp;
import com.tc.model.Cart;
import com.tc.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addcart")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        int menuId = Integer.parseInt(request.getParameter("menuid"));
        String menuName = request.getParameter("menuname");
        float price = Float.parseFloat(request.getParameter("price"));
        String restaurantId = request.getParameter("restaurantid");

        User user = (User) session.getAttribute("loggedInUser");
        session.setAttribute("restaurantid", restaurantId);
        if (user == null) {
            writer.println("Please login to add items to the cart.");
            request.getRequestDispatcher("home").forward(request, response);
            return;
        }

        Map<Integer, Cart> cartItems = (Map<Integer, Cart>) session.getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new LinkedHashMap<>();
        }

        CartDAOImp dao = new CartDAOImp();

        dao.addItemToCart(cartItems, menuId, user.getUserId(), Integer.parseInt(restaurantId), menuName, 1, price);

        session.setAttribute("cartItems", cartItems);
        int totalQuantity = dao.getTotalQuantity(cartItems);
        session.setAttribute("quantity", totalQuantity);

        request.setAttribute("restaurantId", restaurantId);
        request.getRequestDispatcher("menu").forward(request, response);
    }
}
