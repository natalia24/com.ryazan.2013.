<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Game</title>
    <meta charset="UTF-8"/>
    <!--game style-->
    <script src="../../scripts/libs/jquery.js"></script>
    <script src="../../scripts/libs/kinetic.js"></script>
    <script src="../../scripts/libs/underscore.js"></script>
    <script src="../../scripts/libs/backbone.js"></script>
    <!--game script-->
    <script src="../../scripts/game/utils.js"></script>
    <script src="../../scripts/game/managers/canvas-manager.js"></script>
    <script src="../../scripts/game/models/user-model.js"></script>
    <script src="../../scripts/game/views/user-list-view.js"></script>
    <script src="../../scripts/game/views/canvas-view.js"></script>
    <script src="../../scripts/game/managers/game-manager.js"></script>
    <script src="../../scripts/main.js"></script>
    <link rel="stylesheet" href="../../styles/main.css">

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">

    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    <!--link rel="stylesheet" type="text/css" href="../../styles/effects.css" /-->
    <link rel="stylesheet" href="../../styles/main.css">
</head>
<body>

<div class="form-group name" style="padding-bottom: 2px; width: 800px;">
    <h1 class="name">Login PM Quest</h1>
</div>
<div id="game-canvas" style="padding-bottom: 2px; background-color: #069; width: 800px; height: 600px; float: left">

        </div>
        <div id="rates" class="gradient-top-to-bottom" style="margin-left: 15px; background-color: #fff; width: 200px; height: 600px; float: left">
            <div class="form-group">
                <label class="control-label" style="margin-left: 25px; color: #069">Current project teams</label>
                <div>
                    <c:forEach var="progectManager" items="${allPMs}"><br>
                        <img src="http://pngicon.ru//data/media/3/1303507907_User_Green.png" width="50" height="50"/><label class="control-label" style="margin-left: 15px; ">${progectManager.name}  </label>
                        <br>
                        <div style="margin-left: 20px;">
                        <c:forEach var="i" items="${progectManager.usersOK}">
                            <img src="http://portpool.ru/content/icons/transparent/en_ligne.png" width="20" height="20"/>
                        </c:forEach>
                        </div>    
                        <br>
                        <div style="margin-left: 20px;">
                        <c:forEach var="i" items="${progectManager.requestedTeam}">
                            <img src="http://pngicon.ru//data/media/3/1303507907_User_Green.png" width="20" height="20"/>
                        </c:forEach> 
                        </div>
                            <br>
                        <label class="" style="margin-left: 20px; font-size: 12px; font-style: normal">${fn:length(progectManager.usersOK)}  of  ${fn:length(progectManager.requestedTeam)}</label>
                        <br><br><br><br>
                        
                        <%--<div class="progress">--%>
                        <%--<div class="progress-bar" role="progressbar" aria-valuenow="${(fn:length(progectManager.usersOK)/fn:length(progectManager.requestedTeam))*100}" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">--%>
                        <%--<span class="sr-only">60% Complete</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div id="team" class="gradient-top-to-bottom" style="margin-top: 30px; margin-left: 15px; background-color: #fff; width: 1000px; height: 200px; float: left">
            <div class="form-group">
                                <label class="control-label" style="margin-left: 25px; color: #069">Project Resource Requests:</label>
                 <br><br>
                <c:forEach var="skill" items="${userCtx.info.requestedTeam}">                                              
                    <div style="float: left; width: 100px">
                        <img src="http://miranimashek.com/_ph/100/2/180676411.gif" width="80" height="80"/><br>  
                        <label class="control-label" style="margin-left: 25px; color: #1CA3FC">${skill.skillName}  </label>
                    </div>
                </c:forEach>
            </div>               
        </div>

    </body>
</html>
