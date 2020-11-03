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
               <footer>
               <button type="submit" class="btn btn-lg btn-block btn-outline-primary"  name="edit" value="${event.getEventId()}"><fmt:message key="button.edit"/></button>
                </footer>
        </div>
        </div>

    </div>
  </div>
 </form>
</div>
<!-- FOOTER -->
<footer class="footer">
  <div class="container-fluid">
    FOOTER
  </div>
</footer>
    </body>
    </html>