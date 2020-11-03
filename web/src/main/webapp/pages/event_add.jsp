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
<div class="container">
<div id="drop-area">
      <form class="load_pic" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="POST">
        <label class="control-label col-xs-3" for="lastName"><fmt:message key="label.load.image"/></label>
        <div class="col-xs-9">
          <input type="file" name="content" height="130">
          <input type="submit"  class="btn btn-primary" value="Upload File">
        </div >
      </form>
    </div>
<form class="form-horizontal" action="${pageContext.request.contextPath}/controller" method="post">
      <div class="form-group">
        <label class="control-label col-xs-3" for="eventName"><fmt:message key="event.label.name"/></label>
      <div class="col-xs-9">
        <input type="text" class="form-control" id="eventName" name="eventName" placeholder=<fmt:message key="event.placeholder.name"/>>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-xs-3" name="typeEvent" id="typeEvent" ><fmt:message key="event.typeEvent"/></label>
    </div>
    <div class="form-check form-check-inline">
      <label class="radio-inline">
        <input type="radio" name="typeEvent" value="theatre"> <fmt:message key="event.typeEvent.theatre"/>
      </label>
    </div>
    <div class="form-check form-check-inline">
      <label class="radio-inline">
        <input type="radio" name="typeEvent" value="quest"> <fmt:message key="event.typeEvent.quest"/>
      </label>
    </div>
    <div class="form-check form-check-inline">
      <label class="radio-inline">
        <input type="radio" name="typeEvent" value="quest"><fmt:message key="event.typeEvent.creativeWorkShop"/>
      </label>
    </div>
    <div class="form-group">
      <label class="control-label col-xs-3" for="eventDescription"><fmt:message key="event.description"/></label>
      <div class="col-xs-9">
        <textarea rows="8" class="form-control" id="eventDescription" name="eventDescription" placeholder=<fmt:message key="event.description.hint"/>></textarea>
      </div>
    </div>
    <br />
    <div class="form-group">
      <div class="col-xs-offset-3 col-xs-9">
        <input type="submit" class="btn btn-primary" value="Сохранить">
        <input type="reset" class="btn btn-default" value="Отмена ">
      </div>
    </div>
  </form>
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