
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <script src="https://kit.fontawesome.com/10cc1083bb.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="main">
        <section class="signup">
            <div class="container">
            	    <h3 class="status-message">
                        <%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
                    </h3>
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form method="post" action="Register" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="fa-solid fa-user"></i></label>
                                <input type="text" name="username" id="name" placeholder="Your Name" />
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="fa-solid fa-envelope"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email" />
                            </div>
                            <div class="form-group">
                                <label for="contact"><i class="fa-solid fa-phone"></i></label>
                                <input type="text" name="phonenumber" id="contact" placeholder="Contact no" />
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="fa-solid fa-lock"></i></label>
                                <input type="password" name="password" id="pass" placeholder="Password" />
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="fa-solid fa-lock"></i></label>
                                <input type="password" name="cpassword" id="re_pass" placeholder="Repeat your password" />
                            </div>
                            <div class="form-group">
                                <label for="address"><i class="fa-solid fa-location-dot"></i></label>
                                <input type="text" name="address" id="address" placeholder="Your Address" />
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register" />
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure>
                            <img src="images/signup-image.jpg" alt="sign up image">
                        </figure>
                        <a href="login.jsp" class="signup-image-link">I am already a member</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
