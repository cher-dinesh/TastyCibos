package com.tc.controller;

import java.io.IOException;
import java.util.Map;

import com.tc.daoimpl.RestaurantDAOImp;
import com.tc.model.Cart;
import com.tc.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");

        if (user != null) {
            Map<Integer, Cart> cartItems = (Map<Integer, Cart>) session.getAttribute("cartItems");

            if (cartItems != null) {
                float totalAmount = 0;
                for (Cart cartItem : cartItems.values()) {
                    totalAmount += cartItem.getAmount();
                }
                RestaurantDAOImp restaurantDAO = new RestaurantDAOImp();
                String restaurantName = "";
                if (!cartItems.isEmpty()) {
                    int restaurantId = cartItems.values().iterator().next().getRestaurantId();
                    restaurantName = restaurantDAO.getRestaurantName(restaurantId);
                }
                request.setAttribute("restaurantname", restaurantName);
                request.setAttribute("totalamount", totalAmount);
                request.setAttribute("cartItems", cartItems.values());
            } else {
                request.setAttribute("errorMessage", "Your cart is empty.");
            }
        } else {
            request.setAttribute("errorMessage", "Please login to view your cart.");
        }

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
