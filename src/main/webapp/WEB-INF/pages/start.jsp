<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pre-start room.</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="..\..\styles\bootstrap.css">
        <link rel="stylesheet" type="text/css" href="..\..\styles\pre_start.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
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
                                    <button type="button" class="btn btn-primary" >Я готов!</button>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>      
            </fieldset>
            <div class="span4">     
            </div>
        </form>
    </body>
</html>
