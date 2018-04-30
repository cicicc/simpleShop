<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>管理员登陆</title>
  <meta name="author" content="DeathGhost" />
  <link rel="stylesheet" type="text/css" href="../css/dmaku.css" tppabs="css/dmaku.css" />
  <script src="../js/jquery.js"></script>
  <script src="../js/verificationNumbers.js" tppabs="../js/verificationNumbers.js"></script>
  <script src="../js/Particleground.js" tppabs="../js/Particleground.js"></script>
  <script>
      $(document).ready(function() {
          //粒子背景特效
          $('body').particleground({
              dotColor: '#5cbdaa',
              lineColor: '#5cbdaa'
          });
          //验证码
          createCode();
          //测试提交，对接程序删除即可
          $(".submit_btn").click(function(){
              location.href="javascrpt:;"/*tpa=http://***index.html*/;
          });
      });
  </script>
</head>
<body>
<dl class="admin_login">
  <dt>
    <strong>站点后台管理系统</strong>
    <em>Management System</em>
  </dt>
  <dd class="user_icon">
    <input type="text" placeholder="账号" class="login_txtbx"/>
  </dd>
  <dd class="pwd_icon">
    <input type="password" placeholder="密码" class="login_txtbx"/>
  </dd>
  <dd class="val_icon">
    <div class="checkcode">
      <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
      <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
    </div>
    <input type="button" value="看不清验证码" class="ver_btn" onClick="validate();">
  </dd>
  <dd>
    <input type="button" value="立即登陆" class="submit_btn"/>
  </dd>
</dl>
</body>
</html>
