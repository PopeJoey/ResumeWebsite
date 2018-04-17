<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h1 class="title-header">填写内容</h1>
        </section>
    </div>
</div>
<div class="contact">
    <div class="container">
        <div class="contact_bottom">
            <form method="post" action="contact-post.html">
                <div class="contact-to">
                    <input type="text" class="text" value="Name" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name';}">
                    <input type="text" class="text" value="Gender" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}" style="margin-left: 10px">
                    <input type="text" class="text" value="Age" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Subject';}" style="margin-left: 10px">
                </div>
                <div class="contact-to">
                    <input type="text" class="text" value="University and Major" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name';}">
                    <input type="text" class="text" value="Phone Number" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}" style="margin-left: 10px">
                    <input type="text" class="text" value="Email Address" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Subject';}" style="margin-left: 10px">
                </div>
                <div class="text2">
                    <textarea value="Experience:" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Message';}">Message..</textarea>
                </div>
                <div> <a href="#" class="submit">下一步</a> </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
</body>
</html>
