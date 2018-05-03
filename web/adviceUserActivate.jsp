<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <title>请您前去邮箱账号激活</title>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <h2 style="text-align: center">恭喜您,注册成功,请前去注册所用激活此账户</h2>
    <h2 style="text-align: center"><a href="${pageContext.request.contextPath}/index.jsp" style="text-align: center">返回首页</a></h2>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
