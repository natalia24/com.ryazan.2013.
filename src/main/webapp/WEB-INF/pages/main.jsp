<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>webDesigner</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="../../styles/jquery-ui-1.8.19.custom.css"/>
    <link rel="stylesheet" type="text/css" href="../../styles/style.css"/>
    <link rel="stylesheet" type="text/css" href="../../styles/colorpicker.css"/>
    <link rel="stylesheet" type="text/css" href="../../styles/flashlight.css"/>
    <link rel="stylesheet" type="text/css" href="../../styles/text.css"/>

    <script type="text/javascript" src="https://apis.google.com/js/plusone.js"></script>
    <script src="../../js/likes.js"></script>
    <script src="../../js/jquery.js"></script>
    <script src="../../js/underscore.js"></script>
    <script src="../../js/backbone.js"></script>
    <script src="../../js/utils.js"></script>
    <script src="../../js/flashlight.js"></script>
    <script src="../../js/main.js"></script>

</head>


<body>
<div class="main">
    <header id="header">

        <div class="flash-box">
            <p class="flashlight">
                <span class="flash">hackaton</span>
                <span id="light" class="light light-off">2013</span>
            </p>
        </div>

        <!--facebook-->
        <div id="fb-root"></div>
        <div class="fb-like" data-href="https://developers.facebook.com/apps/396546603810289/" data-layout="button_count" data-action="like" data-show-faces="false" data-share="false"></div>

        <!--google+-->
        <div class="g-plusone" data-size="medium" data-href="https://developers.facebook.com/apps/396546603810289/"></div>

        <!--twitter-->
        <a href="https://twitter.com/share" class="twitter-share-button" data-url="https://developers.facebook.com/apps/396546603810289/">Tweet</a>


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