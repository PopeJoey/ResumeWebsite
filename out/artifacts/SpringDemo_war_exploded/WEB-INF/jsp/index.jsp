<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>AWESOME RESUME</title>
  <meta charset="UTF-8">
  <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <script src="js/jquery.min.js"></script>
  <script type="text/javascript">
      jQuery(document).ready(function($) {
          $(".scroll").click(function(event){
              event.preventDefault();
              $('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
          });
      });
  </script>
  <link href="css/style.css" rel='stylesheet' type='text/css' />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <link href='http://fonts.useso.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="header">
  <div class="container">
    <div class="logo"> <a href="/index"><img src="images/lg1.png" alt="resume"></a> </div>
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
<div class="banner text-center">
  <div class="container">
    <div class="banner-info">
      <h1>Customize your unique resume</h1>
      <p>Plenty of beautiful templates, customized content and free service<br>
        Design and download your perfect resume</p>
      <label class="page-scroll"><a class="banner-btn class scroll" href="#feature"><i class="fa fa-angle-double-down fa-4x"></i></a></label>
    </div>
  </div>
</div>
<div class="main">
<div class="content_white">
  <h2>Welcome to our website!</h2>
  <p>It's the group work of 18th group in software engineering class.</p>
</div>
<div class="featured_content" id="feature">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-3 feature_grid1"> <i class="fa fa-shield fa-3x"></i>
        <h3 class="m_1"><a href="#">选择职业</a></h3>
        <p class="m_2">不同的职业在书写简历时需要填写不同的内容，我们根据您的职业为您量身定制简历的模块。</p>
        <a href="#" class="feature_btn">More</a> </div>
      <div class="col-md-3 feature_grid1"> <i class="fa fa-bar-chart fa-3x"></i>
        <h3 class="m_1"><a href="#">填写信息</a></h3>
        <p class="m_2">您可以通过填写提供的表单，或删除某些表单信息，完善您的简历内容。</p>
        <a href="write.jsp" class="feature_btn">More</a> </div>
      <div class="col-md-3 feature_grid1"> <i class="fa fa-flask fa-3x"></i>
        <h3 class="m_1"><a href="#">定制模板</a></h3>
        <p class="m_2">这里有大量的模板供您选择，若您对模板不满意，还可以选择更改模板。</p>
        <a href="#" class="feature_btn">More</a> </div>
      <div class="col-md-3 feature_grid2"> <i class="fa fa-cloud-download fa-3x"></i>
        <h3 class="m_1"><a href="#">下载简历</a></h3>
        <p class="m_2">普通简历无需付费即可下载到您的电脑，您可以选择下载成docx或pdf格式的文件。</p>
        <a href="#" class="feature_btn">More</a> </div>
    </div>
  </div>
</div>
  <div class="footer_bottom">
    <div class="copy">
      <p>Copyright &copy; 2018 AWESOME RESUME by 18th group in software engineering class</p>
    </div>
  </div>
</div>
</body>
</html>
