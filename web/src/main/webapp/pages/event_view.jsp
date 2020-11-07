<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
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
<style>
     <%@include file="style.css" %>
 </style>
<body>

<c:import url="common/header.jsp"/>
<!-- MAIN -->
<main class="main">
<div class="container text-center">
     <form action="${pageContext.request.contextPath}/controller" method="post">
      <input type="hidden" name="command" value ="event_ticket_sale">
    <h1 class="h3 mt-5 mb-1">${eventView.getName()}</h1>
    <h2 class="lead mt-0 mb-5">${eventView.getShortDescription()}</h2>
  <div class="event">
    <div class="container-sm">
        <div class="row">
            <div class="col-7" id="main_pictures">
              <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                  <div class="carousel-item active">
                         <img class="d-block w-100" src="images/carousel/pic1.jpg" alt="First slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="images/carousel/pic2.jpg" alt="Second slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="images/carousel/pic3.jpg" alt="Third slide">
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>
            <div class="col-5" id="event_data">
                <br/>
                <p style="overflow:auto; width: 500px; height:300px;">${eventView.getDescription()}
                </p>
                  <br/>
        <!-- Comments  -->
               <footer>
               <button type="submit" class="btn btn-lg btn-block btn-outline-primary"  name="edit" value="${eventView.getEventId()}"><fmt:message key="button.edit"/></button>
                </footer>
        </div>
        </div>

    </div>
  </div>
 </form>
 <c:forEach items="${listMessages}" var="message">
 <div class="container_mes">
        <img src="/w3images/bandmember.jpg" alt="Avatar" style="width:90px">
        <p><span>${message.getUserId()} Chris Fox.</span> CEO at Mighty Schools.</p>
        <p>${message.getText()}.</p>
    </div>
          </c:forEach>
<div>
<form action="${pageContext.request.contextPath}/controller" method="get">
<input type="hidden" name="command" value ="edit_view">
<table>
        <tr>
        <ul class="pagination">
        <c:if test="${numberPage != 1}">
        <li>
        <a href="${pageContext.request.contextPath}/controller?command=pagination&page=${numberPage - 1}">
        <fmt:message key="page.button.previous"/>
        </a>
        </li>
        </c:if>
        <c:forEach begin="1" end="${countPages}" var="i">
        <c:choose>
        <c:when test="${numberPage eq i}">
        <li>
        <a class="active" href="${pageContext.request.contextPath}/controller?command=pagination&page=${i}">${i}</a>
        </li>
        </c:when>
        <c:otherwise>
        <li>
        <a href="${pageContext.request.contextPath}/controller?command=pagination&page=${i}">${i}
        </a>
        </li>
        </c:otherwise>
        </c:choose>
        </c:forEach>
        <c:if test="${numberPage lt countPages}">
        <li>
        <a href="${pageContext.request.contextPath}/controller?command=pagination&page=${numberPage +1}">
        <fmt:message key="page.button.next"/></a>
        </li>
        </c:if>
        </ul>
        </tr>
        </table>
        </form>
</div>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <div class="form-group">
        <label class="control-label col-xs-3" for="opinionAboutEvent"><fmt:message key="label.opinionAboutEvent"/></label>
        <input type="hidden" name="command" value ="add_message">
        <input type="hidden" name="eventId" value ="${eventView.getEventId()}">
         <input type="hidden" name="numberPage" value ="${numberPage}">
        <div class="col-xs-9">
        <textarea rows="8" class="form-control" id="eventMessage" name="eventMessage"></textarea>
        </br>
        <button type="submit" class=class="btn btn-danger"   name="add" value="${event.getEventId()}"><fmt:message key="button.add"/></button>
<form>
</div>
</div>
</div>
<!-- FOOTER -->
<footer class="footer">
  <div class="container-fluid">
    FOOTER
  </div>
</footer>
    </body>
    </html>