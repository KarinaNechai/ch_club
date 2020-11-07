<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="message"/>
<html>
<head>
  <meta charset="utf-8">
   <title> <fmt:message key="main.title"/></title>
  <meta name="description" content="">
  <meta name="keywords" content="">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   <link href="http://bootstrapformhelpers.com/assets/css/bootstrap-formhelpers.min.css" rel="stylesheet" media="screen">
   <script src="http://bootstrapformhelpers.com/assets/js/bootstrap-formhelpers.min.js"></script>
</head>
<body>
<c:import url="common/header.jsp"/>
<!-- MAIN -->
<main class="main">
<div class="container">
<div class="card-deck mb-3 text-center">
      <c:forEach items="${listEvent}" var="event">
        <div class="card mb-4 box-shadow">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">${event.getName()}</h4>
          </div>
          <img class="card-img-top" src="images/${event.getNamePicture()}" alt="Card image cap">
          <div class="card-body">
            <h1 class="card-title pricing-card-title">$0 <small class="text-muted">/ mo</small></h1>
            <ul class="list-unstyled mt-3 mb-4">
              <p>${event.getShortDescription()}</p>
            </ul>
           <form action="${pageContext.request.contextPath}/controller" method="post">
              <input type="hidden" name="command" value ="event_view">
              <button type="submit" class="btn btn-lg btn-block btn-outline-primary" name="eventId" value="${event.getEventId()}"><fmt:message key="button.view"/></button>
            </form>
            </br>
            <form action="${pageContext.request.contextPath}/controller"" method="post">
            <c:if test="${not empty authUser }">
                <c:if test="${authUser.getRole()=='ADMIN'}">
                    <input type="hidden" name="command" value ="event_edit">
                    <button type="submit" class="btn btn-lg btn-block btn-outline-primary"  name="eventId" value="${event.getEventId()}"><fmt:message key="button.edit"/></button>
                </c:if>
            </c:if>
            </form>
          </div>
        </div>
        </c:forEach>
      </div>
    </main>
    <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>