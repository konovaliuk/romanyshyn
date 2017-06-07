<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp" ></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
	<table>
   <thead>
   	<tr>
   		<th><fmt:message key="offers.from" /></th>
   		<th><fmt:message key="offers.to" /></th>
   		<th><fmt:message key="offers.status" /></th>
   		<th><fmt:message key="form.price" /></th>
   		<th><fmt:message key="form.passengers" /></th>
   		<th><fmt:message key="form.cargo" /></th>
   	</tr>
   </thead>
   <tbody>
	<tr class="object">
	  	<td class="object__item">${offer.placeFrom}</td>
	  	<td class="object__item">${offer.placeTo}</td>
	  	<td class="object__item">${offer.status}</td>
	  	<td class="object__item">${offer.maxPrice}</td>
	  	<td class="object__item">${offer.passangers}</td>
	  	<td class="object__item"><input type="checkbox" disabled <c:if test="${offer.cargo}">checked</c:if> ></td>
	</tr>
	</tbody>
	</table>
	<c:choose>
		<c:when test="${offer.status == 'pending' }">
			<form action="${pageContext.request.contextPath}/Controller" method="POST">
			  	<label><fmt:message key="offer.driver" />: </label><select name="driver_id">
			  		<c:forEach items="${drivers}" var="driver">
			  			<option value="${driver.id}">${driver.lastName}</option>
			  		</c:forEach>
			  	</select>
			  	<input type="hidden" name="command" value="process_offer">
			  	<input type="hidden" name="offer_id" value="${offer.id}">
			  	<input type="submit" value="<fmt:message key="offer.process.offer" />">
			</form>
		</c:when>
		<c:otherwise>
			<p><fmt:message key="offer.driver" />: <a href="${pageContext.request.contextPath}/Controller?page=driver&driver_id=${offer.driverId}">${offer.driver.lastName}</a></p>
		</c:otherwise>
	</c:choose>
		</div>
	</div> <!-- end page class -->
</body>
</html>