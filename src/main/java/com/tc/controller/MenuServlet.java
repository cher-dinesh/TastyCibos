package com.tc.controller;

import java.io.IOException;
import java.util.List;

import com.tc.daoimpl.MenuDAOImp;
import com.tc.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String restaurantId = request.getParameter("restaurantId");
        if(restaurantId==null) {
        	restaurantId=(String)request.getAttribute("restaurantId");
        }
        List<Menu> menuItems = null;
        MenuDAOImp dao=new MenuDAOImp();

        if (restaurantId != null) {
        	menuItems=dao.getMenu(Integer.parseInt(restaurantId));
        }
        request.setAttribute("menuItems", menuItems);
        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }

}
