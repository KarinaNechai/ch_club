<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
 <input type="hidden" name="command" value ="login"></input>
 <table style="with: 50%">
            <tr>
                <td>
                    <input id="login" type="text" name="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input id="password" type="password" name="password"/>
                </td>
            </tr>
        </table>
        <button id="OK" type="submit" name="OK">
          OK
        </button>
</form>
</body>
</html>