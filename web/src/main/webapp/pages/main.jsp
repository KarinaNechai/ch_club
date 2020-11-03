<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="POST">
     Upload File: <input type="file" name="content" height="130">
    <INPUT type="submit" value="Upload File">
 <a href="${pageContext.request.contextPath}/logout">Logout</a>
</form>
</body>
</html>