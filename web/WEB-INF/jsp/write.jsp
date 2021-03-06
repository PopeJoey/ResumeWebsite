<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="include/common_import.jsp" />
</head>
<body>
<jsp:include page="include/header.jsp" />

<div class="about">
    <div class="container">
        <section class="title-section">
            <h1 class="title-header">模板基本信息</h1>
        </section>
    </div>
</div>
<div class="contact">
    <div class="container">
        <div class="contact_bottom">
            <jsp:useBean id="currentResume" class="com.resumeweb.entity.Resume" scope="request" />
            <form:form modelAttribute="currentResume"  method="post" action="./newResume" >
                <div class="form row">
                    <div class="contact-to">
                        <form:input path="resumeName" name="resumeName" id="resumeName" type="text" class="text" value="${sessionScope.currentResume.resumeName}" default='Resume Name'
                                    onFocus="if (this.value == 'Resume Name'){this.value = '';}"
                                    onBlur="if (this.value == '') {this.value = 'Resume Name';}" />
                    </div>
                    <div class="contact-to" style="clear:both;">
                        <form:select path="patternId" name="patternId" id="patternId" class="form-control"
                                     style="width: 32.5%;height:45px;margin: 10px 0;border: 1px solid #E1E2E2;
                                     color: #999;background: #FFF;float: left;outline: none;font-size: 0.85em;">
                            <form:options items="${patternList}" />
                        </form:select>
                    </div>
                </div>
            <div>
                    <div class="submit">
                        <button type="submit" class="btn btn-success">保存信息</button>
                    </div>

                    <div> <a href="./previousStep" class="submit" style="width:104px;text-align:center">上一步</a> </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
</body>
</html>
