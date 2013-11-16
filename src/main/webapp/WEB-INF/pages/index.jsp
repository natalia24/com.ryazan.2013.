<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            </div>
        </div>
        <div id="team" class="gradient-top-to-bottom" style="margin-top: 30px; margin-left: 15px; background-color: #fff; width: 1000px; height: 200px; float: left">
            <div class="form-group" style="padding-left: 30px">
                <label class="control-label" style="margin-left: 25px; color: #069">Project Resource Requests:</label>
                 <br><br>
                <c:forEach var="skill" items="${userCtx.requestedTeam}"> 
                    <div style="float: left; width: 100px">
                      <img src="http://miranimashek.com/_ph/100/2/180676411.gif" width="80" height="80"/><br>  
                      <label class="control-label" style="margin-left: 25px; color: #1CA3FC">${skill.skillName}  </label>
                    </div>
                </c:forEach>
            </div>               
        </div>

    </body>
</html>
