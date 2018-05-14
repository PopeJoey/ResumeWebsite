<%--
  Created by IntelliJ IDEA.
  User: 康靖波
  Date: 2018/4/17
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <div style="padding-right: 22px;">
        <div class="top" align="right">
            <c:choose>
                <c:when test="${sessionScope.currentUser > 0}" >
                    Hello,${sessionScope.userName}
                    <a style="display:inline-block;text-decoration: none;" href="./logout">注销</a>
                </c:when>
                <c:otherwise>
                    <a style="display:inline-block;text-decoration: none;" href="./login">登录</a>
                    <a style="display:inline-block;text-decoration: none;margin-left: 5px;" href="./register">注册</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="logo"> <a href="./homepage"><img src="images/lg1.png" alt="resume"></a> </div>
        <div class="menu"> <a class="toggleMenu" href="#"><img src="images/nav_icon.png" alt="" /> </a>
            <ul class="nav" id="nav">
                <li <c:if test="${page_id == 1}"> class="current"</c:if>><a href="./homepage">首页</a></li>
                <li <c:if test="${page_id == 2}"> class="current"</c:if>><a href="./template">模板</a></li>
                <li <c:if test="${page_id == 3}"> class="current"</c:if>><a href="./my">我的简历</a></li>
                <li <c:if test="${page_id == 4}"> class="current"</c:if>><a href="./contact">联系我们</a></li>
                <li <c:if test="${page_id == 5}"> class="current"</c:if>><a href="./about">关于我们</a></li>
                <div class="clear"></div>
            </ul>
            <script type="text/javascript" src="js/responsive-nav.js"></script>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
