<%@ page import="java.util.List" %>
<%@ page import="com.tc.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="menu.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://kit.fontawesome.com/10cc1083bb.js" crossorigin="anonymous"></script>
</head>
<body>
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
                        <a class="nav-link" href="#offers">Offers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#help">Help</a>
                    </li>
                    <% if (session.getAttribute("loggedInUser") != null) { %>
                        <li class="nav-item">
                            <a class="nav-link" href="cart"><i class="fa-solid fa-cart-shopping"></i> <sup><%= session.getAttribute("quantity") == null ? 0 : session.getAttribute("quantity") %></sup></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="profile.jsp">Profile</a>
                        </li>
                    <% } else { %>
                        <li class="nav-item">
                            <a class="nav-link" href="cart"><i class="fa-solid fa-cart-shopping"></i> <sup>0</sup></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                    <% } %>
                </ul>
            </div>
        </nav>
        
        <div class="container my-4">
        <h1 class="my-4 text-center">Menu</h1>
        <div class="menu-container">
            <%
                List<Menu> menuItems = (List<Menu>) request.getAttribute("menuItems");
                if (menuItems != null && !menuItems.isEmpty()) {
                    for (Menu item : menuItems) {
            %>
                <div class="menu-item card">
                    <img class="card-img-top card-img" src="images/item<%= item.getMenuId() %>.png" alt="images">
                    <div class="card-body">
                        <h5 class="card-title"><%= item.getMenuName() %></h5>
                        <p class="card-text"><%= item.getDescription() %></p>
                        <p class="card-text"><span class="label">Price:</span> $<%= item.getPrice() %></p>
                        <p class="card-text"><span class="label">Available:</span> <%= item.isAvailable() ? "Yes" : "No" %></p>
						<div>
						    <a href="addcart?menuid=<%= item.getMenuId() %>&action=add&restaurantid=<%=item.getRestaurantId() %>&menuname=<%= item.getMenuName() %>&price=<%=item.getPrice() %>" 
						    class="btn btn-primary order-btn">Add To Cart</a>
						</div>
                    </div>
                </div>
            <%
                    }
                } else {
            %>
                <p class="text-center">No menu items found for this restaurant.</p>
            <%
                }
            %>
        </div>
    </div>
	</section>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
