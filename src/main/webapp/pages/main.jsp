<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
 <input type="hidden" name="command" value ="login"></input>
 <h2>Welcome to main page, ${authUser} </h2>
 <a href="${pageContext.request.contextPath}/logout">Logout</a>
</form>
</body>
</html>