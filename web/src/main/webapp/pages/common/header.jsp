<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="message"/>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
      <title> <fmt:message key="main.title"/></title>
  </head>
<body>
<header style="padding-top:5px;" class="header">
      <div class="container-fluid">
        <div class="col-md-12 col-xl-12 logo">
          <div id="logo" style="float:left">
              <img src="images/logo.png">
          </div>
          <div id="contacts" style="float:right;">
          <i>
           <div class="form-group" style="float:right;">
                <form  action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value ="change_locale">
                        <select class="form-control" id="locale"  name ="locale" onchange="submit();">
                            <option value="RU">RU <img src="images/ru.gif"></option>
                            <option value="EN">EN<img src="images/us.gif "></option>
                        </select>
                </form>
            </div>
            </i>
              <i class="fa fa-mobile fa-lg"></i> +375-29-111-11-11 |
              <i class="fa fa-envelope fa-lg"></i> info@testmail.ru
              <i class="fa fa-facebook-square fa-2x" style="margin-left:10px; color: blue;"></i>
          </div>
          <div class="clearfix"></div>

        </div>
         <ctg:user-info/>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
              <a class="navbar-brand" href="#">Hidden brand</a>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                  <li class="nav-item active">
                        <a class="nav-link" href="controller?command=events"> Мероприятия</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="controller?command=event_add"> Мероприятия++</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                  </li>
                </ul>
                  <c:choose>
                        <c:when test="${not empty authUser}">
                            <form  action="${pageContext.request.contextPath}/controller" method="post">
                                <button type="submit" class="btn btn-danger" >
                                    <fmt:message key="main.button.logout"/>
                                </button>
                                <input type="hidden" name="command" value ="logout">
                            </form>
                                </div>
                        </c:when>
                        <c:otherwise>
                        <form class="form-inline" action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command" value ="login"/>
                                <div class="form-group">
                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal_login">
                                        <fmt:message key="main.button.sign.in"/>
                                    </button>
                                </div>
                        </form>
                        </c:otherwise>
                  </c:choose>

                  </br>
            </div>
        </nav>

        <div id="header-bottom" style="position:relative;">
          <img src="images/banner.jpg" style="width:100%;">
          <div id="bannertext" style="position:absolute; top:10%; width:100%; text-align:center; color:white;">
            <div class="hidden-xs">
              <h1>Мы предлагаем<br />
                <small style="color: white;">проведение праздников для вас и ваших детей</small>
              </h1>
            </div>
          </div>
        </div>
    </div>
</header>

<!-- Modal -->
<div class="modal fade" id="modal_login" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="modal_login">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <!-- заголовок -->
            <div class="modal-header">
                <h5 class="modal-title">Логин/Пароль</h5>
                <button type="button" class="close"
                        data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!-- содержимое -->
            <form class="form" action="${pageContext.request.contextPath}/controller" method="post">
            <div class="modal-body">
                   <input type="hidden" name="command" value ="login">
                      <div data-parsley-check-children="2" data-parsley-validate-if-empty="">
                        <div class="first">
                            <label for="inputLogin"><fmt:message key="main.login"/></label>
                                <input type="email" class="form-control" id="login" name="login"
                                    pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                                    data-parsley-length="[8, 15]"
                                    data-parsley-group="block-1"
                                    type="text"/>
                                    <label for="inputPassword1"><fmt:message key="main.password"/></label>
                                <input type="password" class="form-control" id="password" name="password"
                                    data-parsley-length="[8, 15]"
                                    data-parsley-group="block-1"
                                    type="text"/>
                        </div>
                       </div>
            </div>
            <!-- подвал -->
            <div class="modal-footer">
          <!--      <input class="btn btn-default validate" type="submit" > -->
                <button type="submit" class="btn btn-danger" >
                   <fmt:message key="button.send"/>
                </button>
            </div>
           </form>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>

</html>
