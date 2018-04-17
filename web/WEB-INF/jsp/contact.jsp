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

<jsp:include page="include/footer.jsp" />

</body>
</html>
