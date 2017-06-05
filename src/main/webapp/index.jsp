<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="jsp/header.jsp"></c:import>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<div class="main index">
	<h1 class="heading"><fmt:message key="index.invitations" /></h1>
	<a class="btn btn--big" href="#"><fmt:message key="index.page" /></a>
	
        </div>
  </div> <!-- end page class -->
  </body>
</html>
