<%@ page import="java.util.List" %>
<%@ page import="com.tc.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurants</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <script src="https://kit.fontawesome.com/10cc1083bb.js" crossorigin="anonymous"></script>
</head>
<body>
    <section class="hero-section">
        <nav class="navbar navbar-expand-lg navbar-light">
            <a class="navbar-brand brand animate__animated animate__heartBeat" href="home">TastyCibos</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
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
                            <a class="nav-link" href="cart" aria-label="Cart">
                                <i class="fa-solid fa-cart-shopping"></i> <sup><%= session.getAttribute("quantity") == null ? 0 : session.getAttribute("quantity") %></sup>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="profileDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Profile
                            </a>
                            <div class="dropdown-menu" aria-labelledby="profileDropdown">
                                <a class="dropdown-item" href="profile.jsp#settings">Settings</a>
                                <a class="dropdown-item" href="history">Order History</a>
                                <a class="dropdown-item" href="logout">Logout</a>
                            </div>
                        </li>
                    <% } else { %>
                        <li class="nav-item">
                            <a class="nav-link" href="cart" aria-label="Cart">
                                <i class="fa-solid fa-cart-shopping"></i> <sup>0</sup>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                    <% } %>
                </ul>
            </div>
        </nav>

        <div class="hero-container d-flex align-items-center">
            <div class="details-container">
                <h1 class="title animate__animated animate__headShake">Deliciously Fast,<br><span style="color:#F05454">Always Fresh</span></h1>
                <p class="description">Satisfy your cravings with a variety of local delights, delivered hot and fresh right to your door. Explore top-rated restaurants, place your order with ease, and enjoy a gourmet experience without leaving home.</p>
                <a href="#" class="btn btn-primary order-btn">Order Now</a>
            </div>
            <img class="hero animate__animated animate__fadeInDownBig" src="images/mainpage.png" alt="Fast Food">
        </div>
    </section>

	<section class="carousel-section">
	    <div class="d-flex justify-content-between mx-5">
	        <div class="animate__animated animate__fadeInRight text-center">
	            <img alt="Biriyani" src="images/biriyani.png" class="img-fluid carousel-img">
	            <h4 class="mt-2">Biriyani</h4>
	        </div>
	        <div class="animate__animated animate__fadeInRight text-center">
	            <img alt="Chilli" src="images/item3.png" class="img-fluid carousel-img">
	            <h4 class="mt-2">Chilli</h4>
	        </div>
	        <div class="animate__animated animate__fadeInRight text-center">
	            <img alt="Pizza" src="images/pizza.png" class="img-fluid carousel-img">
	            <h4 class="mt-2">Pizza</h4>
	        </div>
	        <div class="animate__animated animate__fadeInRight text-center">
	            <img alt="Noodles" src="images/noodles.png" class="img-fluid carousel-img">
	            <h4 class="mt-2">Noodles</h4>
	        </div>
	        <div class="animate__animated animate__fadeInRight text-center">
	            <img alt="Meals" src="images/rice.png" class="img-fluid carousel-img">
	            <h4 class="mt-2">Meals</h4>
	        </div>
	    </div>
	</section>

    <section class="card-container">
        <h1 class="text-center" style="color:#405D72;">Restaurants</h1>
        <div class="row">
            <% 
                List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurants");
                if (restaurants != null && !restaurants.isEmpty()) {
                    for (Restaurant restaurant : restaurants) {
            %>
                <div class="col-sm-6 col-md-4 col-lg-3 mb-4">
                    <div class="card restaurant-card">
                        <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>" class="card-link">
                            <img src="https://wallpaperaccess.com/full/3014596.jpg" 
                                 alt="Image of <%= restaurant.getRestaurantName() %>" class="card-img-top">
                            <div class="card-body">
                            	<div class="d-flex pt-2">
                            		<h4 class="card-title"><%= restaurant.getRestaurantName() %></h4>
	                                <div class="d-flex align-items-center mb-2 card-rating">
	                                    <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
	                                    <span class="ml-2"><%= restaurant.getRatings() %></span>
	                                </div>
                            	</div>
                                <p class="card-text"><strong>Address:</strong> <%= restaurant.getAddress() %></p>
                                <p class="card-text"><strong>Delivery in:</strong> <%= restaurant.getDeliveryTime() %> minutes</p>
                                <p class="card-text"><strong>Cuisine Type:</strong> <%= restaurant.getCuisineType() %></p>
                                <p class="card-text"><strong>Active:</strong> <%= restaurant.isActive() ? "Yes" : "No" %></p>
                            </div>
                        </a>
                    </div>
                </div>
            <% 
                    }
                } else {
            %>
                <div class="col-12 text-center">
                    <p>No restaurants found.</p>
                </div>
            <% 
                }
            %>
        </div>
    </section>

    <footer class="text-white pt-4 pb-4">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h5>About Us</h5>
                    <p>We offer a wide range of products and services to meet your needs. Explore our collection and enjoy a seamless shopping experience.</p>
                </div>
                <div class="col-md-4">
                    <h5>Quick Links</h5>
                    <ul class="list-unstyled">
                        <li><a href="user.jsp" class="text-white">User</a></li>
                        <li><a href="restaurant.jsp" class="text-white">Restaurants</a></li>
                        <li><a href="menu.jsp" class="text-white">Menu</a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <h5>Contact Us</h5>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Email Us</a></li>
                        <li><a href="#" class="text-white">Call Us</a></li>
                    </ul>
                    <h5>Follow Us</h5>
                    <a href="#" class="text-white mr-2"><i class="fab fa-facebook"></i></a>
                    <a href="#" class="text-white mr-2"><i class="fab fa-twitter"></i></a>
                    <a href="#" class="text-white"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
    </footer>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
