<%--
  Created by IntelliJ IDEA.
  User: josepereira
  Date: 28/04/2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="bootstrap-4.3.1/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style/style.css">

    <title>Template</title>
</head>
<body onload="loadGames(1,1);">
<div class="container">
    <!-- App name -->
    <header class="mt-md-5">
        <div class="row">
            <div class="col-md-12">
                <h1><a href="#" style="text-decoration: none; color:black">Games Library</a></h1>
            </div>
        </div>
    </header>

    <!-- Login pop up -->
    <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body mx-3">
                    <div class="md-form mb-5">
                        <i class="fas fa-envelope prefix grey-text"></i>
                        <label data-error="wrong" data-success="right" for="defaultForm-email">Username</label>
                        <input type="text" id="username" class="form-control validate" value="username">
                    </div>

                    <div class="md-form mb-4">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <label data-error="wrong" data-success="right" for="defaultForm-pass">Password</label>
                        <input type="password" id="password" class="form-control validate" value="password">
                        <label id="loginError" style="visibility: hidden" class="text-danger pt-2">Username or password wrong!</label>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button type="button" class="btn btn-light" action="${pageContext.request.contextPath}\ListGamesAfterLogin">Login</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Warning</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    You need login in your account!
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="row mb-4">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light border rounded px-0 py-2" style="overflow: hidden;">
                <!-- left -->
                <a href="" class="navbar-brand text-secondary text-decoration-none px-2 ml-2" data-toggle="modal" data-target="#modalLoginForm">${requestScope.username}</a>
                <!-- right -->
                <div class="navbar-collapse d-flex justify-content-end">
                    <div>
                        <a class="mx-1 py-5 px-1 text-decoration-none text-secondary font-weight-normal nav-button" href="#">All Games</a>
                        <a class="mx-1 py-5 px-1 text-decoration-none text-secondary font-weight-normal nav-button" href="#" data-toggle="modal" data-target="#exampleModal">My Games</a>
                        <a class="ml-1 py-5 px-1 text-decoration-none text-secondary font-weight-normal nav-button" href="#" data-toggle="modal" data-target="#exampleModal">Add Game</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <!-- FLEX CONTENT -->
    <c:choose>
        <c:when test="${requestScope.page=='ListGames.jsp'}"> <jsp:include page="ListGames.jsp" />
        </c:when>
    </c:choose>

    <!-- footer -->
    <div class="row">
        <div class="col-md-12">
            <footer class="text-center bg-light p-2 border rounded">Footer information ©</footer>
        </div>
    </div>
    <div id="myRawData">

    </div>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="bootstrap-4.3.1/js/jquery-3.3.1.js"></script>
<script src="bootstrap-4.3.1/js/popper.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.js"></script>

<!-- meus scripts -->
<script src="scripts/script.js"></script>
<script src="scripts/game.js"></script>
</body>
</html>
