package com.tc.controller;

import java.io.IOException;
import java.util.List;

import com.tc.daoimpl.RestaurantDAOImp;
import com.tc.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestaurantDAOImp dao = new RestaurantDAOImp();
        List<Restaurant> allRestaurants = dao.getAllRestaurant();

        request.setAttribute("restaurants", allRestaurants);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
