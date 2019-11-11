<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="org.json.*,java.util.*"%>
<%@page import="java.util.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css"
        href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">

    <style>
        body {
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        .lighten-1 {
            background-color: #a6c;
        }

        .lighten-2 {
            background-color: #1f283e;
        }

        li {
            list-style: none;
             color: white;
           
        }

        .nav-link p {
            display: inline-block;
            color: white;
         
        }

        .nav-link {
            display: inline;
            color: white;
        }

        li:hover {
            background-color: #a6c;
            border-radius: 5px;
            color:white;
            width:80%;
            padding-top:10px;
        }
    </style>
</head>

<body>

    <div class="row" height="100vh">
        <div class="col-2 m-0 p-0 lighten-2" style="height: 100vh">
            <div class="text-center lighten-2 ">
                <a class="navbar-brand text-white" href="#">Welcome</a>
            </div>
            <hr>

            <div>
                <ul>
                    <li class="nav-item active">
                       <a class="nav-link" href="/dashboard">
                            <i class="material-icons">dashboard</i>
                            <p>Dashboard</p>
                        </a>
                    </li>


                    <li class="nav-item ">
                        <a class="nav-link" href="#">
                            <i class="material-icons">library_books</i>
                            <p>Menu List</p>
                        </a>
                    </li>

                    <li class="nav-item ">
                        <a class="nav-link" href="#">
                            <i class="material-icons">bubble_chart</i>
                            <p>Chart</p>
                        </a>
                    </li>

                    <li class="nav-item ">
                        <a class="nav-link" href="#">
                            <i class="material-icons">person</i>
                            <p>User Profile</p>
                        </a>
                    </li>

                    <li class="nav-item ">
                        <a class="nav-link" href="/logout">
                            <i class="material-icons">logout</i>
                            <p>Logout</p>
                        </a>
                    </li>
                </ul>
            </div>


        </div>
        <div class="col-10 m-0 p-0">
            <nav class="mb-1 navbar navbar-expand-lg navbar-dark lighten-1">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent-555" aria-controls="navbarSupportedContent-555"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Dashboard
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Menu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Pricing</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-555" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">Dropdown
                            </a>
                            <div class="dropdown-menu dropdown-secondary" aria-labelledby="navbarDropdownMenuLink-555">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav ml-auto nav-flex-icons">
                        <li class="text-white text-center text-capitalize mt-2"> ${name}</li>
                        <li class="nav-item avatar dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-2.jpg" class="rounded w-25"
                                    alt="avatar image">
                            </a>
                            <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
                                aria-labelledby="navbarDropdownMenuLink-55">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="/logout">Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="row justify-content-center">


                <div class="rounded p-0 m-0 w-75">
                    <table class="rounded table table-bordered text-center p-0 m-0">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Veg/NonVeg</th>
                                <th>Jain ?</th>
                                <th>Price (Rs.)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${menuData}" var="item">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.name}</td>
                                    <td><img class="rounded" src="${item.image}" width="50" height="50" /></td>
                                    <td>${item.type}</td>
                                    <td>${item.jain}</td>
                                    <td>${item.price}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>


            </div>
        </div>

</body>

</html>
