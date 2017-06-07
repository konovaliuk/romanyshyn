<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <h1>Drivers page</h1>
  
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<table>
  	<thead>
  		<tr>
  			<th><fmt:message key="drivers.first.name" /></th>
  			<th><fmt:message key="drivers.last.name" /></th>
  			<th><fmt:message key="drivers.car" /></th>
  		</tr>
  	</thead>
  	<tbody>
  	<tr>
  	<td><input type="text" name="first_name" value="${driver.firstName}"></td>
  	<td><input type="text" name="last_name" value="${driver.lastName}"></td>
  	<c:choose >
  		<c:when test="${driver_free}">
  			<td>
  			<select name="car_id">  	
		  		<option value="${driver.carId}">${driver.car.mark}</option>
		  		<c:forEach items="${cars}" var="car">
		  			<option value="${car.id}">${car.mark}</option>
		  		</c:forEach>
	  		</select>
	  		</td>
  		</c:when>
  		<c:otherwise>
  			<td>
  			<select disabled>  	
		  		<option value="${driver.carId}">${driver.car.mark}</option>
		  		<c:forEach items="${cars}" var="car">
		  			<option value="${car.id}">${car.mark}</option>
		  		</c:forEach>
	  		</select>
  			<input type="hidden" name="car_id" value="${driver.carId}">
  			</td>
  		</c:otherwise>
  	</c:choose>  	
  	</tr>
  	</tbody>
  	</table>
  	<input type="hidden" name="command" value="update_driver">
  	<input type="hidden" name="driver_id" value="${driver.id}">
  	<input type="submit" value="<fmt:message key="driver.save" />">
  </form>
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<input type="hidden" name="command" value="delete_driver">
  	<input type="hidden" name="driver_id" value="${driver.id}">
  	<input type="submit" value="<fmt:message key="driver.delete" />">
  </form>
  </div>
  </div>
</body>
</html>