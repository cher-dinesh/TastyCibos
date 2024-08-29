<%@ page import="java.util.Collection" %>
<%@ page import="com.tc.model.Cart" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="cart.css">
    <script src="https://kit.fontawesome.com/10cc1083bb.js" crossorigin="anonymous"></script>
</head>
<body>
    <section class="nav-section">
        <nav class="navbar navbar-expand-lg">
            <a class="navbar-brand brand animate__animated animate__heartBeat" href="home">TastyCibos</a>
            <div class="collapse navbar-collapse flex-row justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="home">Home</a>
                    </li>
                    <% 
                        if (session.getAttribute("loggedInUser") != null) {
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="cart"><i class="fa-solid fa-cart-shopping"></i> <sup><%= session.getAttribute("quantity") %></sup></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profile.jsp">Profile</a>
                    </li>
                    <% 
                        } else { 
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="cart"><i class="fa-solid fa-cart-shopping"></i> <sup>0</sup></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <% 
                        } 
                    %>
                </ul>
            </div>
        </nav>
        <div class="container my-4">
            <h1 class="my-4 text-center">Your Cart</h1>
            <div class="cart-container">
                <h3 class="name">Restaurant: <%= request.getAttribute("restaurantname") %></h3>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Menu Name</th>
                            <th>Quantity</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Collection<Cart> cartItems = (Collection<Cart>) request.getAttribute("cartItems");
                            double totalAmount = 0;
                            double discount = 0;
                            if (cartItems != null && !cartItems.isEmpty()) {
                                for (Cart item : cartItems) {
                                    totalAmount += item.getAmount();
                        %>
                        <tr>
                            <td><%= item.getMenuName() %></td>
                            <td>
                            	<a href="updatecart?menuid=<%= item.getMenuId() %>&action=remove">
                                	<button class="btn btn-danger btn-sm">-</button>
                                </a>
                                <span id="quantity-<%= item.getMenuId() %>"><%= item.getQuantity() %></span>
                          		<a href="updatecart?menuid=<%= item.getMenuId() %>&action=add">
							    	<button class="btn btn-success">+</button>
							    </a>
                            </td>
                            <td>$<span id="amount-<%= item.getMenuId() %>"><%= item.getAmount() %></span></td>
                        </tr>
                        <%
                                }
                                discount = totalAmount * 0.10;
                            } else {
                        %>
                        <tr>
                            <td colspan="3" class="text-center">Your cart is empty.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <%
                double payableAmount = totalAmount - discount;
                String formattedTotalAmount = String.format("%.2f", totalAmount);
                String formattedDiscount = String.format("%.2f", discount);
                String formattedPayableAmount = String.format("%.2f", payableAmount);
                %>
                <table>
                    <tr>
                        <td><h4 class="text-right">Actual Price:</h4></td>
                        <td>$<span id="actualPrice"><%= formattedTotalAmount %></span></td>
                    </tr>
                    <tr>
                        <td><h4 class="text-right">Discount:</h4></td>
                        <td>$<span id="discount"><%= formattedDiscount %></span></td>
                    </tr>
                    <tr>
                        <td><h4 class="text-right">Payable Amount:</h4></td>
                        <td>$<span id="payableAmount"><%= formattedPayableAmount %></span></td>
                    </tr>
                </table>
                
                <div class="payment-options mt-4">
                    <h4>Choose Payment Method</h4>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="paymentMethod" id="gpay" value="GPay">
                        <label class="form-check-label" for="gpay">Google Pay (GPay)</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="paymentMethod" id="phonepe" value="PhonePe">
                        <label class="form-check-label" for="phonepe">PhonePe</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="paymentMethod" id="cod" value="COD">
                        <label class="form-check-label" for="cod">Cash on Delivery (COD)</label>
                    </div>
                    <button class="btn btn-primary mt-3" onclick="makePayment()">Pay</button>
                </div> 
                <form id="checkoutForm" action="checkout" method="post" style="display:none;">
                    <input type="hidden" name="paymentMethod" id="paymentMethodInput">
                    <input type="hidden" name="actualPrice" value="<%= formattedTotalAmount %>">
                    <input type="hidden" name="discount" value="<%= formattedDiscount %>">
                    <input type="hidden" name="payableAmount" value="<%= formattedPayableAmount %>">
                    <input type="hidden" name="restaurantid" value="<%= request.getParameter("restaurantid") %>">
                    <button type="submit" class="btn btn-success mt-3" id="checkoutButton">Checkout</button>
                </form>
            </div>
        </div>
    </section>
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function makePayment() {
            const selectedPaymentMethod = document.querySelector('input[name="paymentMethod"]:checked');
            if (selectedPaymentMethod) {
                alert('Payment successful with ' + selectedPaymentMethod.value);
                document.getElementById('paymentMethodInput').value = selectedPaymentMethod.value;
                document.getElementById('checkoutForm').style.display = 'block';
            } else {
                alert('Please select a payment method.');
            }
        }
    </script>
</body>
</html>
