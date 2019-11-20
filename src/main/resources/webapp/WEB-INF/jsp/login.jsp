<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">


<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            
            background-image: url('https://mediaindia.eu/wp-content/uploads/2016/07/bg_homepage.jpg?w=640');
            background-repeat: no-repeat;
            background-size: 100% 100vh;
            overflow: hidden;
            opacity:0.9;
        }

        .card_title {
            font-family: 'Times New Roman', Times, serif;
        }
    </style>
</head>

<body>

    <div class="w-100 d-flex justify-content-left m-5">

        <form method="POST" class="w-25 center m-5">
            <div class="card mt-5 rounded">
                <div class="card-body rounded">
                    <h3 class="font-weight-bolder text-center text-capitalize card_title">Login</h3>
                    <hr>
                    <div class="form-group">
                        <label for="email" class="font-weight-bolder">Email address:</label>
                        <input type="email" class="form-control" id="email" name="email">
                    </div>
                    <div class="form-group">
                        <label for="password" class="font-weight-bolder">Password:</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                    <div class="form-group form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> Remember me
                        </label>
                    </div>
                    <div class="row justify-content-center">
                        <button type="submit" class="btn btn-outline-success w-50">Login</button>
                    </div>
                    <p class="m-1 text-danger">${errorMsg}</p>
                </div>
            </div>

        </form>

    </div>



</body>

</html>