<%--
  Created by IntelliJ IDEA.
  User: jfc
  Date: 2019-04-22
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="row">
    <div class="col-md-8  ">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Games</th>
                <th id="year" scope="col">Year</th>
                <th scope="col">Plataform</th>
            </tr>
            </thead>
            <tbody id="myTable">

            </tbody>
        </table>
    </div>
    <div class="col-md-4">
        <aside>
            <b>Filter</b>
            <form class="align-middle pb-4">
                <select class="w-100 mt-3">
                    <c:forEach var="year" items="${requestScope.years}">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>
                <select class="w-100 mt-3">
                    <c:forEach var="platform" items="${requestScope.platforms}">
                        <option value="${platform}">${platform}</option>
                    </c:forEach>
                </select>
            </form>
            <form method="GET" action="${pageContext.request.contextPath}/AddGame">
                <c:choose>
                    <c:when test="${requestScope.addButton == 'addButton'}">
                        <button type="submit" class="btn btn-light w-100 my-3" >Add new</button>
                    </c:when>
                </c:choose>
            </form>
        </aside>
    </div>
</div>
<div class="row">
    <div class="col-md-8 bg-white d-flex justify-content-end">
        <nav id="pagination" aria-label="Page navigation example">
                <ul class="pagination">
                    <c:forEach var="i" begin="1" end="${requestScope.maxPages}">
                        <li class="page-item">
                            <button onclick="loadGames(${i}, '${requestScope.action}', '${pageContext.request.contextPath}', ${sessionScope.logedIn});" class="page-link">${i}</button>
                        </li>
                    </c:forEach>
                </ul>
        </nav>
    </div>
</div>