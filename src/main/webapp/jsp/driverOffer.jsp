<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <h1><fmt:message key="offer.driver.heading" /></h1>
	<c:choose >
		<c:when test="${offer eq null}">
			<h2>Wait for offers</h2>
		</c:when>
		<c:otherwise>
			<form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<table>
   <thead>
   	<tr>
   		<th><fmt:message key="offers.from" /></th>
   		<th><fmt:message key="offers.to" /></th>
   		<th><fmt:message key="offers.status" /></th>
   		<th><fmt:message key="offer.state" /></th>
   	</tr>
   </thead>
   <tbody>
	<tr class="object">
	  	<td class="object__item">${offer.placeFrom}</td>
	  	<td class="object__item">${offer.placeTo}</td>
	  	<td class="object__item">${offer.status}</td>
		<td>
  	<select name="state_id">
  		<c:forEach items="${states}" var="state">
  			<option value="${state.id}">${state.name}</option>
  		</c:forEach>
  	</select>
  		</td>
  		</tr>
  		</tbody>
  		</table>
  	<input type="hidden" name="command" value="end_offer">
  	<input type="hidden" name="offer_id" value="${offer.id}">
  	<input type="submit" value="<fmt:message key="offer.end.offer" />">
  </form>
		</c:otherwise>
	</c:choose>
  
  </div>
  </div>
</body>
</html>