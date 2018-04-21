<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="include/common_import.jsp" />
    <style type="text/css">

        body{
            background: url("images/login1.jpg");
            animation-name:myfirst;
            animation-duration:12s;
            animation-delay:2s;
            animation-iteration-count:infinite;
            animation-play-state:running;
        }
        /*
                @keyframes myfirst
                {
                    0%   {background:url("images/login1.jpg");}
                    34%  {background:url("images/2.jpg");}
                    67%  {background:url("images/3.jpg");}
                    100% {background:url("images/login1.jpg");}
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
<jsp:include page="include/header.jsp" />

<div class="container" >
    <div class="form row">
        <div class="form-horizontal" id="login_form">
            <br>
            <!--
            <h3 class="form-title" style="text-align: center">登录</h3>
            -->
            <div class="col-md-offset-2">
                <div class="col-md-10">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="账号" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password" name="password" maxlength="8"/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/>
                            <h5>记住我</h5>
                        </label>
                    </div>
                    <div class="form-group col-md-offset-9">
                        <a href="./my"><button type="submit" class="btn btn-success" style="width:100%;background-color: #7cc4cc;border-color: #7cc4cc" name="submit">登录</button></a>
                    </div>
                    <br>
                    <div class="form-group col-md-offset-9">
                        <a href="./register">
                            <button type="submit" class="btn btn-success" style="width:100%;background-color: #7cc4cc;border-color: #7cc4cc">无账号？注册</button>
                        </a>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />

</body>
</html>