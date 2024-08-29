<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFE3D8;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            width: 50vw;
            height: 60vh;
            background: rgba(255, 255, 255, 0.3);
            border-radius: 16px;
            box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(5px);
            -webkit-backdrop-filter: blur(5px);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Order Confirmation</h1>
        <div class="alert alert-success text-center">
            <strong>Thank you for your order!</strong> Your payment has been successfully processed.
        </div>
        <div class="text-center">
            <a href="home" class="btn btn-primary">Continue Shopping</a>
        </div>
    </div>
</body>
</html>
