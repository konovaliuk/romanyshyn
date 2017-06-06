<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:import url="header.jsp"></c:import>
	<h1 class="eroor__heading">Oooops, something went wrong</h1>
	<c:out value="${error}"></c:out>
</body>
</html>