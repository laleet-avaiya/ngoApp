<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <style>
        body{
            padding: 0px 2px;
            margin: 0px 2px;
        }
        .lighten-1 {
            /*background-color: #a6c;*/
            background-color: forestgreen;
            font-weight: bold;
            font-family: SansSerif;
            letter-spacing: 1px;
        }

        .ngo-label{
            font-family: SansSerif;
            margin: 20px;
        }
    </style>
</head>

<body>

    <nav class="mb-1 navbar navbar-expand-lg navbar-dark lighten-1">
        <a class="navbar-brand" href="#">Welcome</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
            aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/dashboard">Dashboard
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/ngo/all">NGOS</a>
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
                        <a class="dropdown-item" href="logout">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>


    <div class="container">
    <div class="row mt-5">
        <div class="col-3">
            <div class="card">
                <div class="card-header bg-dark text-white">Registered NGO'S :
                    <span class="badge badge-primary">${ngos.size()}</span>
                </div>
            </div>
        </div>

        <div class="col-3">
            <div class="card">
                <div class="card-header bg-success text-white">Approved NGO'S:
                    <span class="badge badge-secondary">${ngos.size()}</span></div>
            </div>
        </div>

        <div class="col-3">
            <div class="card">
                <div class="card-header bg-info text-white">Rejected NGO'S:
                    <span class="badge badge-warning">${ngos.size()}</span>
                </div>
            </div>
        </div>
        <div class="col-3">
            <div class="card">
                <div class="card-header bg-danger text-white">Rejected NGO'S:
                    <span class="badge badge-warning">${ngos.size()}</span>
                </div>
            </div>
        </div>
    </div>
    </div>


    <div class="container mt-5">
        <h2 class="text-center ngo-label">NGO's</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Logo</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>registered_on</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ngos}" var="ngo">
            <tr>
                <td><img src="${ngo.logo}" height="30" width="30"></img></td>
                <td>${ngo.name}</td>
                <td>${ngo.phone}</td>
                <td>${ngo.email}</td>
                <td>${ngo.registered_on}</td>

                <td>
                <c:if test = "${ngo.status==true}">
                    <form name="submitForm" method="POST" action="approve">
                        <input type="hidden" name="email" value="${ngo.email}">

                        <A HREF="javascript:document.submitForm.submit()"><button class="btn btn-success">Reject</button></A>
                    </form>
                </c:if>

                    <c:if test = "${ngo.status==false}">
                        <form name="submitForm" method="POST" action="approve">
                            <input type="hidden" name="email" value="${ngo.email}">
                            <A HREF="javascript:document.submitForm.submit()"><button class="btn btn-danger">Approve</button></A>
                        </form>
                    </c:if>

                </td>

            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>







</body>

</html>