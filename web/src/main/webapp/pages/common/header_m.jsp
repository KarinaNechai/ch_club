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
<div class="modal fade" id="modal_login" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
    <div class="container-fluid">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                <span aria-hidden="true">&times;
                </span>
            </button>
        </div>
        <div class="modal-content">
            <div class="tab" role="tabpanel">
            <!-- Nav tabs -->
                <ul class="nav nav-pills nav-fill" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true"><fmt:message key="main.button.sign.in"/></a></li>
                    <li class="nav-item"><a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"><fmt:message key="main.button.sign.up"/></a></li>
                </ul>
            <!-- Tab panes -->
                <div class="tab-content tabs">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command" value ="login"/>
                            <div class="form-group">
                                <label for="inputLogin"><fmt:message key="main.login"/></label>
                                <input type="email" class="form-control" id="login" name="login"
                                 pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword1"><fmt:message key="main.password"/></label>
                                <input type="password" class="form-control" id="password" name="password">
                            </div>
                            <div class="form-group">
                                <div class="main-checkbox">
                                    <input value="None" id="checkbox1" name="check" type="checkbox">
                                    <label for="checkbox1"></label>
                                </div>
                                <span class="text"><fmt:message key="main.keep.in.sign"/></span>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default"><fmt:message key="main.button.sign.in"/></button>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command" value ="registry"/>
                            <div class="form-group">
                                <label for="InputFirstName"><fmt:message key="main.label.first.name"/></label>
                                <input type="text" class="form-control" id="firstName">
                             </div>
                             <div class="form-group">
                                 <label for="InputLastName"><fmt:message key="main.label.last.name"/></label>
                                 <input type="text" class="form-control" id="lastName">
                             </div>
                             <div class="form-group">
                                 <label for="InputEmail"><fmt:message key="main.label.email.address"/></label>
                                 <input type="email" class="form-control" id="login"
                                  pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
                             </div>
                             <div class="form-group">
                                 <label for="Password1"><fmt:message key="main.label.password"/></label>
                                 <input type="password" class="form-control" id="password">
                             </div>
                             <div class="form-group">
                                <button type="submit" class="btn btn-default"><fmt:message key="main.button.sign.up"/></button>
                             </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<header style="padding-top:5px;" class="header">
  <div class="container-fluid">
      <div class="col-md-12 col-xl-12 logo">
        <div id="logo" style="float:left">
          <img src="../images/logo.png">
        </div>
        <div id="contacts" style="float:right;">
          <i class="fa fa-mobile fa-lg"></i> +375-29-111-11-11 |
          <i class="fa fa-envelope fa-lg"></i> info@mail.ru
          <i class="fa fa-facebook-square fa-2x" style="margin-left:10px; color: blue;"></i>
        </div>
        <div class="clearfix"></div>
      </div>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="#">Hidden brand</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="controller?command=event_add"> Мероприятия</a>
                 </li>
                 <li class="nav-item">
                    <a class="nav-link" href="controller?command=events">Просмотреть мероприятия </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Творческая мастерская</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="list1_desc">
                    <div class="form-group">
                    <form action="${pageContext.request.contextPath}/controller" method="get">
                        <select class="form-control" id="sel1">
                            <option value="RU"><a href="${pageContext.request.contextPath}?locale=ru">RU</a></option>
                            <option value="EN"><a href="${pageContext.request.contextPath}?locale=en">EN</a></option>
                        </select>
                       </form>
                    </div>
                </li>
                </br>
                 <li class="list1_desc">
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal_login">
                        Вход
                    </button>
                </li>
                <form action="${pageContext.request.contextPath}/controller" method="posr">
                   <a href="${pageContext.request.contextPath}/controller?command=locale?locale=EN">EN</a>
                   <a href="${pageContext.request.contextPath}/controller?command=locale?locale=ru">RU</a>
                </form>
            </ul>
          </div>
        </nav>
</div>
</header>
</body>
</html>
