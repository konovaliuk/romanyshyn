<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <h1><fmt:message key="car.heading" /></h1>
  <h2><c:out value="${operation_result}"></c:out></h2>
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<table>
  	<thead>
  		<tr>
  			<th><fmt:message key="cars.mark" /></th>
  			<th><fmt:message key="cars.price" /></th>
  			<th><fmt:message key="cars.cargo" /></th>
  			<th><fmt:message key="cars.state" /></th>
  		</tr>
  	</thead>
  	<tbody>
  	<tr>
  	<td><p>${car.mark}</p></td>
  	<td><p>$ ${car.price}</p></td>
  	<td>
  	<c:choose>
  		<c:when test="${car.cargo}">
  			<label>Cargo</label><input type="checkbox" checked disabled>
  		</c:when>
  		<c:otherwise>
  			<label>Cargo</label><input type="checkbox" disabled>
  		</c:otherwise>  		
  	</c:choose>
  	</td>
  	<td>
  	<select name="state_id">
  		<c:forEach items="${states}" var="state">
  			<c:choose>
	  			<c:when test="${state.id eq car.stateId}">
	  				<option value="${state.id}" selected="selected">${state.name}</option>
	  			</c:when>
	  			<c:otherwise>
	  				<option value="${state.id}">${state.name}</option>
	  			</c:otherwise>
  			</c:choose>
  		</c:forEach>
  	</select>
  	</td>
  	</tr>
  	</tbody>
  	</table>
  	<input type="hidden" name="command" value="update_car">
  	<input type="hidden" name="car_id" value="${car.id}">
  	<input type="submit" value="<fmt:message key="car.update" />">
  </form>
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<input type="hidden" name="command" value="delete_car">
  	<input type="hidden" name="car_id" value="${car.id}">
  	<input type="submit" value="<fmt:message key="car.delete" />">
  </form>
  </div>
  </div>
</body>
</html>