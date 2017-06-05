<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
	<c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <h1><fmt:message key="offers.heading" /></h1>
  <table>
   <thead>
   	<tr>
   		<th></th>
   		<th><fmt:message key="offers.from" /></th>
   		<th><fmt:message key="offers.to" /></th>
   		<th><fmt:message key="offers.status" /></th>
   	</tr>
   </thead>
   <tbody>
  <c:forEach items="${offers}" var="offer">
  	<tr class="object ${offer.status}">
	  	<td class="object__item"><a class="btn" href="${pageContext.request.contextPath}/Controller?page=offer&offer_id=${offer.id}"><fmt:message key="offers.to.offer" /></a></td>
	  	<td class="object__item">${offer.placeFrom}</td>
	  	<td class="object__item">${offer.placeTo}</td>
	  	<td class="object__item">${offer.status}</td>
	</tr>
  </c:forEach>
  </tbody>
  </table>
  	</div>
  </div> <!-- end page class -->
</body>
</html>