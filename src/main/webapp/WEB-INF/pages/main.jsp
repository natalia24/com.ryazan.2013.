<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>webDesigner</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/jquery-ui-1.8.19.custom.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/style.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/colorpicker.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/flashlight.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/styles/text.css"/>

    <script type="text/javascript" src="https://apis.google.com/js/plusone.js"></script>
    <script src="../resources/script/jquery.js"></script>
    <script src="../resources/script/underscore.js"></script>
    <script src="../resources/script/backbone.js"></script>
    <script src="../resources/script/utils.js"></script>
    <script src="../resources/script/flashlight.js"></script>
    <script src="../resources/script/main.js"></script>

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
        <script>(function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/ru_RU/all.js#xfbml=1&appId=396546603810289";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>
        <div class="fb-like" data-href="https://developers.facebook.com/apps/396546603810289/" data-layout="button_count" data-action="like" data-show-faces="false" data-share="false"></div>

        <!-- Place this tag where you want the +1 button to render. -->
        <div class="g-plusone" data-size="medium" data-href="https://developers.facebook.com/apps/396546603810289/"></div>

        <!-- Place this tag after the last +1 button tag. -->
        <script type="text/javascript">
            window.___gcfg = {lang: 'ru'};

            (function() {
                var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
                po.src = 'https://apis.google.com/js/plusone.js';
                var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
            })();
        </script>

        <a href="https://twitter.com/share" class="twitter-share-button" data-url="https://developers.facebook.com/apps/396546603810289/">Tweet</a>
        <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>



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