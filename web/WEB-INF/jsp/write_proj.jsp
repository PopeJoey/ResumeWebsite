<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="contact_bottom">
                <form method="post" action="contact-post.html">
                    <div class="contact-to">
                        <input type="text" class="text" value="Project name" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Project name';}">
                        <select class="form-control" style="width: 32.5%;height:45px;margin: 10px 0;border: 1px solid #E1E2E2;color: #999;background: #FFF;float: left;outline: none;font-size: 0.85em;margin-left: 30px">
						<option>个人经历</option>
						<option>实习经历</option>
						<option>工作经历</option>
						<option>其他</option>
						</select>
                        
                    </div>
					<div class="contact-to">
                        <input type="text" class="text" value="Start time" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Start time';}">
                        <input type="text" class="text" value="End time" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'End time';}" style="margin-left: 30px">
                    </div>
					 <div class="text2">
                        <textarea value="Description:" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Describe your project';}">Describe your project</textarea>
                    </div>
                    <div > <a href="#" class="submit" style="margin-left: 30px">完成</a> </div>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="include/footer.jsp" />
    </body>
</html>
