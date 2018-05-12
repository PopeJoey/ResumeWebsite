<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="include/common_import.jsp" />
</head>
<jsp:include page="include/header.jsp" />
    <div class="about">
        <div class="container">
            <section class="title-section">
                <h1 class="title-header">最后一步</h1>
            </section>
        </div>
    </div>
    <div class="contact">
        <div class="container">
            <div class="contact_bottom" id="projects">
                <c:forEach items="${sessionScope.currentResume.projects}" var="project" varStatus="loopCount">
                <div class="oneProject" pid="${project.projectInfoId}" itemOrder="${loopCount.count}">
                    <div class="contact-to">
                        <input type="text" id="projectName" class="text" placeholder="ResumeName" value="${project.projectName}"/>

                        <select class="form-control" style="width: 32.5%;height:45px;margin: 10px 0;border: 1px solid #E1E2E2;color: #999;background: #FFF;float: left;outline: none;font-size: 0.85em;margin-left: 30px" id="proOrIntern" value="${project.proOrIntern}">
                        <option>个人经历</option>
                        <option>实习经历</option>
                        <option>工作经历</option>
                        <option>其他</option>
                        </select>

                    </div>
                    <div class="contact-to">
                        <input type="text" id="startDate" class="text"  placeholder="Start time" value="${project.startDate}" />
                        <input type="text" id="endDate" class="text" placeholder="End time(No input represents 'up to now')" value="${project.endDate}" style="margin-left: 30px"/>
                    </div>
                     <div class="text2">
                         <textarea placeholder="Describe your project" id="description">${project.description}</textarea>
                    </div>
                    <button class="submit" onclick="saveInfo(${loopCount.count})">保存</button>
                    <button class="submit" onclick="removeInfo(${loopCount.count})">删除此项</button>
                </div>
                </c:forEach>
            </div>
            <button class="submit" onclick="addItem()">添加一项项目信息</button>
            <button class="submit" onclick="location.reload();">下一步</button>
            <a href="./previousStep" class="submit">上一步</a>

        </div>
    </div>
    <jsp:include page="include/footer.jsp" />

<script type="text/javascript">
    function addItem() {
        var itemId = $("#projects").children().length;
        var emptyProject = {
            "projectId":"\"\"",
            "projectName":"\"\"",
            "proOrIntern":"\"\"",
            "startDate":"\"\"",
            "endDate":"\"\"",
            "description":"\"\""
        };
        $("#projects").append(getItemHTML(itemId,emptyProject));
    }
</script>

<script type="text/javascript">
    function saveInfo(itemOrder) {
        postData = {};
        postData["projectId"] = $(".oneProject:eq("+ itemOrder +")").attr("pid");
        postData["projectName"] = $("#projectName:eq("+ itemOrder +")").val();
        postData["proOrIntern"] = $("#proOrIntern:eq("+ itemOrder +")").val();
        postData["startDate"] = $("#startDate:eq("+ itemOrder +")").val();
        postData["endDate"] = $("#endDate:eq("+ itemOrder +")").val();
        postData["description"] = $("#description:eq("+ itemOrder +")").val();
        $.ajax({
            type : "post",
            url : "./newProjectInfoAjax?itemOrder=" + itemOrder,
            contentType : "application/json",
            dataType : "json",
            data : JSON.stringify(postData),

            success: function (data, textStatus) {
                var obj = eval(data);
                if(obj == "" || obj == null){
                    return false;
                }

                if(obj.isSucceed){
                    alert("保存成功");
                }
            }
        });
    }
</script>
<script type="text/javascript">
    function removeInfo(itemOrder) {
        if(!confirm('确实要删除该内容吗?')){
            return;
        }
        $.ajax({
            type:"post",
            url:"./removeProjectAjax?itemOrder=" + itemOrder,
            dataType:"json",
            data:{},

            success:function (data, textStatus) {
                var obj = eval(data);
                if(obj == "" || obj == null){
                    return false;
                }

                if(obj.isSucceed){
                    var projects = obj.projects;
                    var htmlStr = "";
                    for(i = 0; i < projects.length;i++){
                        htmlStr += getItemHTML(i,projects[i]);
                    }
                    $("#projects").html(htmlStr);
                }
            }
        });
    }
</script>
<script type="text/javascript">
    function getItemHTML(itemId,project){
        var htmlStr = '<div class="oneProject" pid=' + project.prjectId + ' itemOrder="'+ itemId +'">';
        htmlStr += '<div class="contact-to">';
        htmlStr += '<input type="text" id="projectName" class="text" placeholder="Project Name" value=' + project.projectName + '/>';
        htmlStr += '<select class="form-control" style="width: 32.5%;height:45px;margin: 10px 0;border: 1px solid #E1E2E2;color: #999;background: #FFF;float: left;outline: none;font-size: 0.85em;margin-left: 30px" id="proOrIntern" value='+ project.proOrIntern +'>';
        htmlStr += '<option>个人经历</option><option>实习经历</option><option>工作经历</option><option>其他</option>';
        htmlStr += '</select>';
        htmlStr += '</div>';
        htmlStr += '<div class="contact-to">';
        htmlStr += '<input type="text" id="startDate" class="text"  placeholder="Start time" value=' + project.startDate +' />';
        htmlStr += '<input type="text" id="endDate" class="text" placeholder="End time(No input represents \'up to now\')" value=' + project.endDate + ' style="margin-left: 30px"/>';
        htmlStr += '</div>';
        htmlStr += '<div class="text2">';
        htmlStr += '<textarea placeholder="Describe your project" id="description" value=' + project.description +' />';
        htmlStr += '</div>';
        htmlStr += '<button class="submit" onclick="saveInfo(' + itemId + ')">保存</button>';
        htmlStr += '<button class="submit" onclick="removeInfo(' + itemId + ')">删除此项</button>';
        htmlStr += '</div>';
        return htmlStr;
    }
</script>
    </body>
</html>
