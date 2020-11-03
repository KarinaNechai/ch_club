<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.topnav {
  background-color: #333;
  overflow: hidden;
}
.topnav a {
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>
<form action="${pageContext.request.contextPath}/controller" method="get">
<ul id="navbar">
	<li><a href="#">Main</a></li>
	<li><a href="#">News</a></li>
	<li><a href="#">Contacts</a>
		<ul>
			<li><a href="#">Adress</a></li>
			<li><a href="#">Phone</a></li>
			<li><a href="#">Email</a></li>

		</ul>
	</li>
     <li><a href="#" >About Us</a></li>
	 <li><a style="float:right"  href="<%=request.getContextPath()%>/logout">Logout</li>
   </ul>
   <form>
    <a href="${pageContext.request.contextPath}?locale=ru" style="padding: 5px">RU</a>
    <a href="<%=request.getContextPath()%>/controller?locale=en" style="padding: 5px">EN</a>
    </form>
</form>