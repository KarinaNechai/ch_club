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
    <form:form action="${pageContext.request.contextPath}/registration/save" method="post"
               modelAttribute="user">
        <table>
            <tr>
                <td>
                    <spring:message code="page.login"/>
                </td>
                <td>
                    <form:input path="login" type="text" name="login" value="${user.login}"></form:input>
                    <form:errors path="login" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="page.password"/>
                </td>
                <td>
                    <form:input path="password" type="password" name="password" value="${user.password}"></form:input>
                    <form:errors path="password" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="page.lastName"/>
                </td>
                <td>
                    <form:input path="lastName" type="text" name="lastName" value="${user.lastName}"></form:input>
                    <form:errors path="lastName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="page.firstName"/>
                </td>
                <td>
                    <form:input path="firstName" type="text" name="firstName" value="${user.firstName}"
                    pattern="[А-Яа-я]*?\s[А-Яа-я]*?\s[А-Яа-я]*"></form:input>
                    <form:errors path="firstName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="page.email"/>
                </td>
                <td>
                    <form:input path="email" type="email" name="email" value="${user.email}"></form:input>
                    <form:errors path="email" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="page.phone"/>
                </td>
                <td>
                    <form:input path="phone" type="tel" maxlength="50" name="phone" value="${user.phone}"
                                pattern="\+375\-[0-9]{2}\-[0-9]{3}\-[0-9]{2}\-[0-9]{2}"
                                placeholder="+375-___-___-__-__"></form:input>
                    <form:errors path="phone" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form action="${pageContext.request.contextPath}/registration/save" method="post">
                        <button id="save" type="submit" name="save">
                            <spring:message code="page.button.Ok"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/registration/cancel" method="post">
                        <button type="submit" name="cancel">
                            <spring:message code="page.button.Cancel"/>
                        </button>
                    </form>
                </td>
            </tr>
        </table>
    </form:form>
</jsp:root>

