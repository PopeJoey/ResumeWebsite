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
                <h1 class="title-header">第二步</h1>
            </section>
        </div>
    </div>
    <div class="contact">
        <div class="container">
            <div class="contact_bottom">
                <form method="post" action="contact-post.html">
                    <div class="contact-to">
                        <input type="text" class="text" value="Education" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Education';}">
                        <input type="text" class="text" value="University" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'University';}" style="margin-left: 30px">
                        
                    </div>
                    <div class="contact-to">
						<input type="text" class="text" value="Major" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Major';}" >
                        <input type="text" class="text" value="Rank" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Rank';}" style="margin-left: 30px">
					</div>
					<div class="contact-to">
                        <input type="text" class="text" value="Start time" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Start time';}">
                        <input type="text" class="text" value="End time" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'End time';}" style="margin-left: 30px">
                    </div>
					<br><br><br><br><br>
                    <div > <a href="./3" class="submit" style="margin-left: 30px">下一步</a> </div>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="include/footer.jsp" />
    </body>
</html>
