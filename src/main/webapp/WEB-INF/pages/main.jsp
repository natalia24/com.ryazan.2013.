<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ru.tver.hackaton.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>webDesigner</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/jquery-ui-1.8.19.custom.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/style.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/colorpicker.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/flashlight.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/text.css"/>
</head>

<script src="../resources/script/jquery.js"></script>
<script src="../resources/script/underscore.js"></script>
<script src="../resources/script/backbone.js"></script>
<script src="../resources/script/utils.js"></script>
<script src="../resources/script/flashlight.js"></script>
<script src="../resources/script/main.js"></script>
<body>
<div class="main">
    <header id="header">

        <div class="flash-box">
            <p class="flashlight">
                <span class="flash">hackaton</span>
                <span id="light" class="light light-off">2013</span>
            </p>
        </div>
    </header>
    <div class="red_line"></div>

    <div id="wrapper">

        <section id="middle">

            <div id="container">

                <div id="content">
                    <label>canvas toush modes:</label>
                    <div id="letterpress">
                        <h2>The simpsons</h2>
                    </div>

                    <div id="person-container">
                        <ul id="person-list">

                        </ul>
                    </div>

                </div>
            </div>
        </section>
    </div>
</div>

<footer id="footer">
    <div class="red_line"/>
</footer>
<!-- #footer -->
</body>
</html>