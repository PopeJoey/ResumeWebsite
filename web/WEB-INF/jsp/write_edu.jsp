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
                <h1 class="title-header">第二步</h1>
            </section>
        </div>
    </div>
    <div class="contact">
        <div class="container">
            <div class="contact_bottom" id="educations">
                <c:forEach items="${sessionScope.currentResume.educations}" var="education" varStatus="loopCount">
                <div class="oneEducation" eid="${education.eduInfoId}" itemOrder="${loopCount.count}">
                    <div class="contact-to">
                        <input type="text" class="text" id="edu" value="${education.edu}" placeholder="Education" />
                        <input type="text" class="text" id="school" placeholder="University" value="${education.school}"/>
                        
                    </div>
                    <div class="contact-to">
						<input type="text" class="text" id="major" placeholder="Major" value="${education.major}" />
                        <input type="text" class="text" id="rank" placeholder="Rank" value="${education.rank}" />
					</div>
					<div class="contact-to">
                        <input type="text" class="text" id="startDate" placeholder="Start time" value="${education.startDate}"/>
                        <input type="text" class="text" id="endDate" placeholder="End time" value="${education.endDate}"/>
                    </div>
                    <button class="submit" onclick="saveInfo(${loopCount.count})">保存</button>
                    <button class="submit" onclick="removeInfo(${loopCount.count})">删除此项</button>


                </div>
                </c:forEach>
            </div>
            <button class="submit" onclick="addItem()">添加一项教育信息</button>
            <button class="submit" onclick="location.reload();">下一步</button>
            <div > <a href="./previousStep" class="submit" style="margin-left: 30px">上一步</a> </div>
        </div>
    </div>
    <jsp:include page="include/footer.jsp" />

<script type="text/javascript">
    function addItem() {
        var itemId = $("#educations").children().length;
        var emptyEducation = {
            "eduInfoId":"\"\"",
            "startDate":"\"\"",
            "endDate":"\"\"",
            "school":"\"\"",
            "major":"\"\"",
            "edu":"\"\"",
            "rank":"\"\""
        };
        $("#educations").append(getItemHTML(itemId,emptyEducation));
    }
</script>

<script type="text/javascript">
    function saveInfo(itemOrder) {
        postData = {};
        postData["eduInfoId"] = $(".oneEducation:eq("+ itemOrder +")").attr("eid");
        postData["startDate"] = $("#startDate:eq("+ itemOrder +")").val();
        postData["endDate"] = $("#endDate:eq("+ itemOrder +")").val();
        postData["school"] = $("#school:eq("+ itemOrder +")").val();
        postData["major"] = $("#major:eq("+ itemOrder +")").val();
        postData["edu"] = $("#edu:eq("+ itemOrder +")").val();
        postData["rank"] = $("#rank:eq("+ itemOrder +")").val();
        $.ajax({
            type : "post",
            url : "./newEduInfoAjax?itemOrder=" + itemOrder,
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
            url:"./removeEduAjax?itemOrder=" + itemOrder,
            dataType:"json",
            data:{},

            success:function (data, textStatus) {
                var obj = eval(data);
                if(obj == "" || obj == null){
                    return false;
                }

                if(obj.isSucceed){
                    var educations = obj.educations;
                    var htmlStr = "";
                    for(i = 0; i < educations.length;i++){
                        htmlStr += getItemHTML(i,educations[i]);
                    }
                    $("#educations").html(htmlStr);
                }
            }
        });
    }
</script>
<script type="text/javascript">
    function getItemHTML(itemId,education){
        var htmlStr = '<div class="oneEducation" eid=' + education.eduInfoId +' itemOrder=' + itemId +' >';
        htmlStr += '<div class="contact-to">';
        htmlStr += '<input type="text" class="text" id="edu" placeholder="Education"  value=' + education.edu + '/>';
        htmlStr += '<input type="text" class="text" id="school" placeholder="University" value=' + education.school + '/>';
        htmlStr += '</div>';
        htmlStr += '<div class="contact-to">';
        htmlStr += '<input type="text" class="text" id="major" placeholder="Major" value=' + education.major + ' />';
        htmlStr += '<input type="text" class="text" id="rank" placeholder="Rank" value=' + education.rank + ' />';
        htmlStr += '</div>';
        htmlStr += '<div class="contact-to">';
        htmlStr += '<input type="text" class="text" id="startDate" placeholder="Start time" value=' + education.startDate + ' />';
        htmlStr += '<input type="text" class="text" id="endDate" placeholder="End time" value=' + education.endDate + ' />';
        htmlStr += '</div>';
        htmlStr += '<button class="submit" onclick="saveInfo(' + itemId + ')">保存</button>';
        htmlStr += '<button class="submit" onclick="removeInfo(' + itemId + ')">删除此项</button>';
        htmlStr += '</div>';
        return htmlStr;
    }
</script>
    </body>
</html>
