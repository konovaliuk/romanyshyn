<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <h1><fmt:message key="drivers.heading" /></h1>
  <table>
  <thead>
  	<tr>
  		<th></th>
  		<th><fmt:message key="drivers.first.name" /></th>
  		<th><fmt:message key="drivers.last.name" /></th>
  	</tr>
  </thead>
  <tbody>
  <c:forEach items="${drivers}" var="driver">
  	<tr>
  	<td><a class="btn" href="${pageContext.request.contextPath}/Controller?page=driver&driver_id=${driver.id}"><fmt:message key="drivers.to.driver" /></a></td>
  	<td><p>${driver.firstName}</p></td>
	<td><p>${driver.lastName}</p></td>
	</tr>
  </c:forEach>
  </tbody>
  </table>
  </div>
  </div>
</body>
</html>