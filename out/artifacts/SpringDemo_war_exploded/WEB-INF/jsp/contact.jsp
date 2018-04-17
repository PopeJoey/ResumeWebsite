<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>联系我们</title>
    <meta charset="UTF-8">
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <script src="js/jquery.min.js"></script>
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href='http://fonts.useso.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'></link>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="logo"> <a href="index.jsp"><img src="images/lg1.png" alt="resume"></a> </div>
        <div class="menu"> <a class="toggleMenu" href="#"><img src="images/nav_icon.png" alt="" /> </a>
            <ul class="nav" id="nav">
                <li class="current"><a href="/index">首页</a></li>
                <li><a href="/template">模板</a></li>
                <li><a href="/about">关于我们</a></li>
                <li><a href="/contact">联系我们</a></li>
                <li><a href="/login">登录</a></li>
                <li><a href="/register">注册</a></li>
                <div class="clear"></div>
            </ul>
            <script type="text/javascript" src="js/responsive-nav.js"></script>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<div class="about">
  <div class="container">
    <section class="title-section">
      <h1 class="title-header">Contact Us</h1>
    </section>
  </div>
</div>
<div class="contact">
  <div class="container">
    <div class="row contact_top">
      <div class="col-md-4 contact_details">
        <h5>Mailing address:</h5>
        <div class="contact_address"> 湖北省武汉市武昌区武汉大学计算机学院</div>
      </div>
      <div class="col-md-4 contact_details">
        <h5>Call us:</h5>
        <div class="contact_address"> +1 800 123 1234<br>
        </div>
      </div>
      <div class="col-md-4 contact_details">
        <h5>Email us:</h5>
        <div class="contact_mail"> iss@whu.edu.cn</div>
      </div>
    </div>
    <div class="contact_bottom">
      <h3>Contact Form</h3>
      <p>您的满意是我们最大的追求</p>
      <form method="post" action="contact-post.html">
        <div class="contact-to">
          <input type="text" class="text" value="Name" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name';}">
          <input type="text" class="text" value="Email" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}" style="margin-left: 10px">
          <input type="text" class="text" value="Subject" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Subject';}" style="margin-left: 10px">
        </div>
        <div class="text2">
          <textarea value="Message:" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Message';}">Message..</textarea>
        </div>
        <div> <a href="#" class="submit">Send Message</a> </div>
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
