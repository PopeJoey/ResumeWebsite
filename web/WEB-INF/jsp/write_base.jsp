<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="include/common_import.jsp" />
	<script>
        var Select = {
        del : function(obj,e){
        if((e.keyCode||e.which||e.charCode) == 8){
        var opt = obj.options[0];
        opt.text = opt.value = opt.value.substring(0, opt.value.length>0?opt.value.length-1:0);
        }
        },
        write : function(obj,e){
        if((e.keyCode||e.which||e.charCode) == 8)return ;
        var opt = obj.options[0];
        opt.selected = "selected";
        opt.text = opt.value += String.fromCharCode(e.charCode||e.which||e.keyCode);
        }
        }
	</script>
</head>
<body>

    <jsp:include page="include/header.jsp" />
    <div class="about">
        <div class="container">
            <section class="title-section">
                <h1 class="title-header">第一步</h1>
            </section>
        </div>
    </div>
    <div class="contact">
        <div class="container">
            <div class="contact_bottom">
                <jsp:useBean id="BaseInfo" class="com.resumeweb.entity.BaseInfo" scope="request">
                    <jsp:setProperty name="BaseInfo" property="userId" value="${sessionScope.currentUser}"/>
                </jsp:useBean>
                <form:form modelAttribute="BaseInfo" method="post" action="./newResume">
                    <div class="contact-to" style="clear:both;">
                        <form:input path="name" type="text" class="text" value="${sessionScope.currentResume.baseInfo.name}" placeholder="Name" />
                        <form:input path="birthDate" type="text" class="text" value="${sessionScope.currentResume.baseInfo.birthDate}" placeholder="BirthDay" />
                        <form:input path="phoneNumber" type="text" class="text" value="${sessionScope.currentResume.baseInfo.phoneNumber}" placeholder="PhoneNumber" style="margin-left: 10px" />
                        <form:input path="highestEdu" type="text" class="text" value="${sessionScope.currentResume.baseInfo.highestEdu}" placeholder="Highest Education" />
                    </div>
                    <div class="contact-to" style="clear:both;">
                        <form:input path="country" type="text" class="text" value="${sessionScope.currentResume.baseInfo.country}" placeholder="Country" />

                        <form:select path="gender" value="${sessionScope.currentResume.baseInfo.gender}"
                                     class="form-control" onkeydown="Select.del(this,event)" onkeypress="Select.write(this,event)"
                                     style="width: 32.5%;height:45px;margin: 10px 0;border: 1px solid #E1E2E2;color: #999;background: #FFF;float: left;outline: none;font-size: 0.85em;margin-left: 10px">
                            <option>男</option>
                            <option>女</option>
                        </form:select>
                        <form:input path="email" type="text" class="text" value="${sessionScope.currentResume.baseInfo.email}" placeholder="Email"/>
                    </div>
                    <div class="text2">
                        <form:textarea path="simpleIntroduction" value="${sessionScope.currentResume.baseInfo.simpleIntroduction}" placeholder="Self-instroduction" />
                    </div>
                    <button type="submit" class="btn btn-success">保存并转到下一步</button>
                    <div> <a class="submit" href="./previousStep">上一步</a> </div>
                </form:form>
            </div>
        </div>
    </div>

<jsp:include page="include/footer.jsp" />
    </body>
</html>
