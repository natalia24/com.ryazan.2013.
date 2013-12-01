<%-- 
    Document   : login
    Created on : 16.11.2013, 11:03:12
    Author     : Наташулька
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Epam PM Quest</title>

        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">

        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../../styles/main.css">
    </head>
    <body id="linearBg">
        <div class="login container gradient-top-to-bottom" id="cent">
            <form class="form-horizontal" method="POST">
                <div class="form-group name">
                    <h1 class="name">Login PM Quest</h1>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-9 col-sm-1">
                        <button type="submit" class="btn btn-default">Log in</button>
                    </div>
                </div>
                <c:if test="${error}">
                    Неправильное имя пользователя или пароль
                </c:if>
            </form>
        </div>
    </body>
</html>
