<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
	<c:import url="header.jsp"></c:import>
	<h1 class="error__heading"><fmt:message key="error.ops" /></h1>
	<div class="exception-message">
		<p>${pageContext.exception.message}</p>
		<p>${pageContext.exception.stackTrace}</p>
		<c:forEach var="stackTraceElem" items="${pageContext.exception.stackTrace}">
			<c:out value="${stackTraceElem}"/><br/>
		</c:forEach>
	</div>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>