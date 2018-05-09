<%--
  Created by IntelliJ IDEA.
  User: 康靖波
  Date: 2018/4/21
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="include/common_import.jsp" />
</head>
<body>

<jsp:include page="include/header.jsp" />
<div class="about">
    <div class="container">
        <section class="title-section">
            <h1 class="title-header">我的简历 </h1>
        </section>
    </div>
</div>

<a href="./newResume" >新建简历</a>

<div class="container" style="height:360px">
    <table class="table">
        <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>01</td>
            <td>个人风格</td>
            <td>
                <a href="#" class="btn btn-default btn-sm">修改</a>
                    <a href="#"  class="btn btn-default btn-sm">预览</a>
                        <a href="#"  class="btn btn-default btn-sm">下载</a>
                            <a href="#"  class="btn btn-default btn-sm">删除</a>
            </td>

        </tr>
        </tbody>

    </table>
</div>

<jsp:include page="include/footer.jsp" />

</body>
</html>
