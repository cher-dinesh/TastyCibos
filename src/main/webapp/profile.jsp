<%@ page import="com.tc.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="profile.css">
</head>
<body>
    <div class="container my-4">
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
                       <a class="nav-link" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    	
        <h1 class="my-4 text-center">Profile</h1>
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <div class="card">
                    <div class="card-body">
                        <%
                            User loggedInUser = (User) session.getAttribute("loggedInUser");
                            if (loggedInUser != null) {
                        %>
                        <form action="update_profile" method="post">
                            <div class="form-group">
                                <label for="userName">Username:</label>
                                <input type="text" class="form-control" id="userName" name="username" value="<%= loggedInUser.getUserName() %>">
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" class="email" value="<%= loggedInUser.getEmail() %>">
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber">Phone Number:</label>
                                <input type="text" class="form-control" id="phoneNumber" class="phonenumber" value="<%= loggedInUser.getPhoneNumber() %>">
                            </div>
                            <div class="form-group">
                                <label for="address">Address:</label>
                                <input type="text" class="form-control" id="address" class="address" value="<%= loggedInUser.getAddress() %>">
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="text" class="form-control" id="password" class="password" value="<%= loggedInUser.getPassword() %>">
                            </div>
                            <div><input type="submit" value="Save Changes"></div>
                        </form>
                        <% 
                            } else {
                        %>
                        <p class="text-center">No user data found. Please <a href="login.jsp">login</a> first.</p>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
