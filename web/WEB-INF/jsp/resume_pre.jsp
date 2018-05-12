<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <style type="text/css">
    html,body{margin:0px; padding:0px;}
    .lab{margin-top:10px;color:rgb(74,145,115);font-size:20px;}
    .tex{color:rgb(190,190,190);font-size:17px;white-space:pre-wrap;}
    .lab-to{margin-top:0;color:rgb(74,145,115);font-size:20px;}
    .block-one{padding-left:23px;padding-right:23px;}
  </style>
</head>

<body style="background-color:black;">
<c:forEach var="info" items="${ResumeList}" >
<div class="resume" style="dispaly:inline-block;background-color:white;width:685px;position:absolute;left:50%;transform:translate(-50%);-webkit-transform:translate(-50%);-moz-transform:translate(-50%);-ms-transform:translate(-50%);">
  <div style="width:225px;dispaly:inline-block;float:left;">
    <div style="height:205px;padding-left:23px;padding-top:13px;">
      <img src="images/a1.jpg" style="border-radius:50%;width:80%;height:80%;">
    </div>
    <div style="padding-left:23px;">
      <span class="lab">Gender</span><br>
      <span class="tex">${info.gender} </span><br><br>


      <span class="lab">Birth</span><br>
      <span class="tex">${info.birth_date} </span><br><br>


      <span class="lab">Age</span><br>
      <span class="tex">${info.age}</span><br><br>


      <span class="lab">Tel</span><br>
      <span class="tex">${info.phone_number}</span><br><br>


      <span class="lab">Address</span><br>
      <span class="tex">${info.country}</span><br><br>


      <span class="lab">Email</span><br>
      <span class="tex">${info.email}</span><br><br>
    </div>
  </div>
  <div style="width:450px;dispaly:inline-block;float:left;margin-left:0;">
    <div style="height:205px;">
      <br><br>
      <span  style="margin-top:155px;margin-left:23px;color:rgb(74,145,115);font-size:33px;">Java后台开发</span><br>
      <span style="margin-left:25px;color:rgb(190,190,190);font-size:22px;">${baseinfo.name}</span>
    </div>
    <div class="block-one">
      <span class="lab-to">Self-introducion</span><br>
      <span class="tex">${info.simple_introduction}</span><br><br><br><br>
    </div>
    <div class="block-one">
      <span class="lab-to">Education</span><br>
      <span class="tex">${info.edu}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${info.school}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${info.major}</span><br>
      <span class="tex">${info.eduStartDate}</span><span class="tex">-</span><span class="tex">${info.eduEndDate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${info.rank}</span><br><br><br><br>
     </div>
    <div class="block-one">
      <span class="lab-to">Project experience1</span><br>
      <span class="tex">${info.projectName}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${info.proOrIntern}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${info.proStartDate}</span><span class="tex">-</span><span class="tex">${info.proEndDate}</span>
      <span class="tex">${info.description}</span><br><br><br><br>
    </div>
  </div>
</div>
</c:forEach>
</body>
</html>
