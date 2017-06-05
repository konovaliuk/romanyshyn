<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<table>
  	<thead>
  		<tr>
  			<th><fmt:message key="cars.mark" /></th>
  			<th><fmt:message key="cars.price" /></th>
  			<th><fmt:message key="cars.cargo" /></th>
  			<th><fmt:message key="car.capacity" /></th>
  			<th><fmt:message key="cars.state" /></th>
  		</tr>
  	</thead>
  	<tbody>
  	<tr>
  	<td><input type="text" name="mark"></td>
  	<td><input type="number" name="price"></td>
  	<td><input type="checkbox" name="cargo" id="cargo"></td>
  	<td><input type="number" name="capacity" min=1 max=40></td>
  	<td><select name="state_id">
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
  	<input type="hidden" name="command" value="create_car">
  	<input type="submit" value="<fmt:message key="cars.add.car" />">
  </form>
  </div> <!-- end page class -->
</body>
</html>