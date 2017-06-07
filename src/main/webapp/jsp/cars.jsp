<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <h1><fmt:message key="cars.heading" /></h1>
  <a class="btn btn--nice" href="${pageContext.request.contextPath}/Controller?page=car_form"><fmt:message key="cars.add.car" /></a>
  <table>
   <thead>
   	<tr>
   		<th></th>
   		<th><fmt:message key="cars.mark" /></th>
   		<th><fmt:message key="cars.price" /> $</th>
   		<th><fmt:message key="cars.state" /></th>
   	</tr>
   </thead>
   <tbody>
  <c:forEach items="${cars}" var="car">
  	<tr class="object ${car.state.name}">
	  	<td class="object__item"><a class="btn" href="${pageContext.request.contextPath}/Controller?page=car&car_id=${car.id}"><fmt:message key="cars.to.car" /></a></td>
	  	<td class="object__item">${car.mark}</td>
	  	<td class="object__item">${car.price}</td>
	  	<td class="object__item">${car.state.name}</td>
  	</tr>
  </c:forEach>
  </tbody>
  </table>
  </div>
  </div>
</body>
</html>