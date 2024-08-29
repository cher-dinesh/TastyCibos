<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign up</title>
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<script src="https://kit.fontawesome.com/10cc1083bb.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="main">
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>
					<div class="signin-form">
						<h2 class="form-title">Sign up</h2>
						<form method="post" action="Login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i class="fa-solid fa-envelope"></i></label> 
								<input type="email" name="email" id="username" placeholder="cher@gmail.com" />
							</div>
							<div class="form-group">
								<label for="password"><i class="fa-solid fa-lock"></i></label> 
								<input type="password" name="password" id="password" placeholder="Password" />
							</div>

							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin" class="form-submit"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>