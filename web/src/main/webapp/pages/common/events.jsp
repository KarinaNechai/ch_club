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
</main>
<div id="method">
<div class="row" style="text-align:center; background:#f3f3f3;"
 <h2>Наши мероприятия </h2>
        <br/>
        <div>
      <div class="row" style="text-align:center; background:#f3f3f3;">

         <c:forEach items="${listEvent}" var="event">
        <ul style="list-style:none; margin:15px; padding:10px; box-shadow:0 0 5px #aaa;
background: #FFF; border-radius: 3px;">
        <li class="list1_img" style="float:left; width: 36%;"><img src="images/pic1.jpg" class="img-responsive"></li>
        <li class="list1_desc" style="float:left; width:61%; margin-left:1em;">
          <div class="row">
            <h3>${event.getName()}</h3>
                <p>${event.getDescription()}</p>
          </div>
          <div class="row">
            <button type="button" class="btn btn-primary" data-toggle="modal"     data-target="#modal_login">View</button>
            <button type="button" class="btn btn-primary" data-toggle="modal"     data-target="#modal_login">
                   Edit
            </button>
            </div>
      </li>
      <div class="clearfix"> </div>
    </ul>
</c:forEach>
 <ul class="pagination">
  <li><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
</ul>
      </div>
    </div>
</head>
</html>