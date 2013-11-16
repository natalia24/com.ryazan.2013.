<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </head>
    <body>  

        <div class="form-group name" style="padding-bottom: 2px; width: 800px;">
            <h1 class="name">Login PM Quest</h1>
        </div>    
        <div id="game-canvas" style="padding-bottom: 2px; background-color: #069; width: 800px; height: 600px; float: left"></div>
        <div id="rates" class="gradient-top-to-bottom" style="margin-left: 15px; background-color: #fff; width: 200px; height: 600px; float: left"></div>
        <div id="team" class="gradient-top-to-bottom" style="padding-right: 15px; background-color: #fff; width: 1000px; height: 200px; float: left"></div>

    </body>
</html>