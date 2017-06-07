<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<jsp:include page="header.jsp" />
	
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<div class="form">
	    <div class="row"><label><fmt:message key="login.login" /> </label><input type="text" name="login"></div>
	    <div class="row"><label><fmt:message key="login.password" /> </label><input type="password" name="password"></div>
	    <input type="hidden" name="command" value="login">
	    <div class="row"><input type="submit" value="<fmt:message key="login.sign.in" />"></div>
	</div>
  </form>
</body>
</html>