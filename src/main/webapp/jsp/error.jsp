<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="header.jsp" />
	<h1>Error page</h1>
	<c:out value="${error}"></c:out>
</body>
</html>