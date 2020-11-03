<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="message"/>
<html>
     <head>
        <title> <fmt:message key="main.title"/></title>
        <style>
         <%@include file='style.css' %>
         </style>
           </head>
    <body>
        <div id="container" style="width:100%">
            <div id="header" style="background-color:#A3FFC2;">
               <%@include file="navigationTop.jsp" %>
            </div>
            <div id="menu" style="background-color:#f1f1f1;height:calc(100vh - 40px);width:200px;float:left;">
                <%@include file="navigationLeft.jsp" %>
            </div>
            <div id="content" style="background-color: #fff;height:200px;width:1000px;float:left;">
                <div class="example_content2 ">
                    <form action="${pageContext.request.contextPath}/controller" method="post">
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
                </div>
                <div id="footer" class="footer">
                    Copyright © 2020 www.aeroflot.by
                </div>
            </div>
        </div>
    </body>
</html>