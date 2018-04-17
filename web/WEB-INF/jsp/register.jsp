<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="include/common_import.jsp" />

    <style type="text/css">

        body{
            background: url("images/1.jpg");
            animation-name:myfirst;
            animation-duration:12s;
            animation-delay:2s;
            animation-iteration-count:infinite;
            animation-play-state:running;
        }
        /*
                @keyframes myfirst
                {
                    0%   {background:url("images/1.jpg");}
                    34%  {background:url("images/2.jpg");}
                    67%  {background:url("images/3.jpg");}
                    100% {background:url("images/1.jpg");}
                }
        */
        .form{background: rgba(255,255,255,0.2);width:400px;margin:120px auto;}
        /*阴影*/
        .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
        input[type="text"],input[type="password"]{padding-left:26px;}
        .checkbox{padding-left:21px;}
    </style>

</head>
<body>
<div background="images/1.jpg">
    <div class="header" style="background-color: rgba(0,0,0,0)">
        <div class="container">
            <div class="logo"> <a href="index.jsp"><img src="images/lg1.png" alt="resume"></a> </div>
            <div class="menu"> <a class="toggleMenu" href="#"><img src="images/nav_icon.png" alt="" /> </a>
                <ul class="nav" id="nav">
                    <li><a href="./homepage">首页</a></li>
                    <li><a href="./template">模板</a></li>
                    <li><a href="./about">关于我们</a></li>
                    <li><a href="./contact">联系我们</a></li>
                    <li><a href="./login">登录</a></li>
                    <li class="current"><a href="./register">注册</a></li>
                    <div class="clear"></div>
                </ul>
                <script type="text/javascript" src="js/responsive-nav.js"></script>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>

    <div class="container">
        <div class="form row">
            <div class="form-horizontal" id="login_form">
                <br>
                <div class="col-md-offset-2">
                    <div class="col-md-10">
                        <div class="form-group" style="margin-bottom: 0px">
                            <i class="fa fa-user fa-lg"></i>
                            <input class="form-control required" type="text" placeholder="账号" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                        </div>
                        <div class="form-group" style="margin-bottom: 0px">
                            <i class="fa fa-user fa-lg"></i>
                            <input class="form-control required" type="text" placeholder="邮箱" id="email" name="username" autofocus="autofocus" maxlength="20"/>
                        </div>
                        <div class="form-group" style="margin-bottom: 0px">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="密码" id="password" name="password" maxlength="8"/>
                        </div>
                        <div class="form-group" style="margin-bottom: 30px">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="确认密码" id="identifyPassword" name="password" maxlength="8"/>
                        </div>
                        <div class="form-group col-md-offset-9">
                            <button type="submit" class="btn btn-success" style="width:100%;background-color: #7cc4cc;border-color: #7cc4cc" name="submit">注册</button>
                        </div>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />

</body>
</html>