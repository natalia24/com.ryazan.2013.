<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>EPAM PM Quest</title>
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="..\..\styles\bootstrap.css">
        <link rel="stylesheet" type="text/css" href="..\..\styles\pre_start.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script>
            function startGame() {
                $.ajax({
                    type: "GET",
                    url: "../game/start" ,
                    success: function(){
                        window.location = "../game/test1";
                    }
                });
            }
        </script>
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Участники игры</legend>
                <div class="row-fluid">
                    <div class="span4">  
                        <table id="members" class="table table-bordered">
                            <tr>
                                <th align="center">Логин участника</th>
                                <th align="center">Статус</th>
                            </tr>
                            <c:forEach var="user" items="${loggedIn}">
                            <tr>
                                <td>                          
                                    <input type="text" readonly="true" id="loginField" value="${user.token.additionalInformation.userBean.fullname}"></div>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-primary" onclick="startGame()">Я готов!</button>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>      
            </fieldset>
            <div class="span4">     
            </div>
        </form>
        <%@include file="epam_screen.jsp" %>
    </body>
</html>
