<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>表单填写</title>
    <meta charset="UTF-8">
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <script src="js/jquery.min.js"></script>
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href='http://fonts.useso.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>
</head>

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
<div class="footer">
    <div class="footer_bottom">
        <div class="copy">
            <p>Copyright &copy; 2018 AWESOME RESUME by 18th group in software engineering class</p>
        </div>
    </div>
</div>
</body>
</html>
