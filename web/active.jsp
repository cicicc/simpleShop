<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <title>欢迎您来激活邮箱</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<h2 style="text-align: center">欢迎您来激活邮箱</h2>
<%--<h2 style="text-align: center"><a href="${pageContext.request.contextPath}/login.jsp" style="text-align: center">立即登录</a></h2>--%>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>