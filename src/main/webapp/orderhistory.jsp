<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tc.model.OrderHistory" %>
<%@ page import="com.tc.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order History</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="history.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://kit.fontawesome.com/10cc1083bb.js" crossorigin="anonymous"></script>
</head>
<body>
  <div class="history-container">
  	  <section class="nav-section">
        <nav class="navbar navbar-expand-lg">
            <a class="navbar-brand brand animate__animated animate__heartBeat" href="home">TastyCibos</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse flex-row justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profile.jsp">Profile</a>
                    </li>
                </ul>
            </div>
        </nav>
    </section>

    <section class="container mt-5">
        <h2>Order History</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Price</th>
                    <th>Payment Method</th>
                    <th>Order Date</th>
                    <th>Status</th>
                    
                </tr>
            </thead>
            <tbody>
                <% 
                    List<OrderHistory> orderHistoryList = (List<OrderHistory>) session.getAttribute("history");
                    if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
                        for (OrderHistory order : orderHistoryList) {
                %>
                <tr>
                    <td><%= order.getOrderTable().getOrderId() %></td>
                    <td><%= order.getTotalAmount() %></td>
                    <td><%= order.getpaymentMethod() %></td>
                    <td><%= order.getOrderDate() %></td>
                    <td><%= "Delivered" %></td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr>
                    <td colspan="5" class="text-center">No orders found.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </section> 
  </div>
</body>
</html>
