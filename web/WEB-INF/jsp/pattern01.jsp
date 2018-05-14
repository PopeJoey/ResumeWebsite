<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="resume" style="dispaly:inline-block;background-color:white;width:685px;position:absolute;left:50%;transform:translate(-50%);-webkit-transform:translate(-50%);-moz-transform:translate(-50%);-ms-transform:translate(-50%);">
  <div style="width:225px;dispaly:inline-block;float:left;">
    <div style="height:205px;padding-left:23px;padding-top:13px;">
      <img src="../images/a1.jpg" style="border-radius:50%;width:80%;height:80%;">
    </div>
    <div style="padding-left:23px;">
      <span class="lab">Gender</span><br>
      <span class="tex">${currentResume.baseInfo.gender} </span><br><br>


      <span class="lab">Birth</span><br>
      <span class="tex">${currentResume.baseInfo.birthDate} </span><br><br>


      <span class="lab">Tel</span><br>
      <span class="tex">${currentResume.baseInfo.phoneNumber}</span><br><br>


      <span class="lab">Address</span><br>
      <span class="tex">${currentResume.baseInfo.country}</span><br><br>


      <span class="lab">Email</span><br>
      <span class="tex">${currentResume.baseInfo.email}</span><br><br>
    </div>
  </div>
  <div style="width:450px;dispaly:inline-block;float:left;margin-left:0;">
    <div style="height:205px;">
      <br><br>
      <span  style="margin-top:155px;margin-left:23px;color:rgb(74,145,115);font-size:33px;">${currentResume.resumeName}</span><br>
      <span style="margin-left:25px;color:rgb(190,190,190);font-size:22px;">${currentResume.baseInfo.name}</span>
    </div>
    <div class="block-one">
      <span class="lab-to">Self-introducion</span><br>
      <span class="tex">${currentResume.baseInfo.simpleIntroduction}</span><br><br><br><br>
    </div>
    <div class="block-one">
      <span class="lab-to">Educations</span><br>
      <c:forEach items="${currentResume.educations}" var="education" >
        <span class="tex">${education.edu}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${education.school}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${education.major}</span><br>
        <span class="tex">${education.startDate}</span><span class="tex">-</span><span class="tex">${education.endDate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${education.rank}</span><br><br><br><br>
        </br>
      </c:forEach>
     </div>
    <div class="block-one">
      <span class="lab-to">Project experiences</span><br>
      <c:forEach items="${currentResume.projects}" var="project">
        <span class="tex">${project.projectName}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${project.proOrIntern}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="tex">${project.startDate}</span><span class="tex">-</span><span class="tex">${project.endDate}</span>
        <span class="tex">${project.description}</span><br><br><br><br>
      </c:forEach>
    </div>
  </div>
</div>
</body>
</html>
