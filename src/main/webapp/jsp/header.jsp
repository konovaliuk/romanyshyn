<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${param['page']}"></c:out></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<script
	    src="https://code.jquery.com/jquery-3.2.1.min.js"
	    integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	    crossorigin="anonymous">
  </script>
</head>
<body>
	<c:if test="${not empty message}">
		<div id="message">
			<c:choose>
				<c:when test="${message == 'login'}">
					<p><fmt:message key="message.login" /></p>
				</c:when>
				<c:otherwise>
					<p><fmt:message key="message.form" /></p>
				</c:otherwise>	
			</c:choose>
		</div>
	</c:if>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
	<div class="header">
		<div class="menu">
		<ul class="nav">
		<c:choose>
			<c:when test="${sessionScope.user.role.name != 'unregistered'}">
				<li class="nav__link"><a href="${pageContext.request.contextPath}/Controller?page=main"><fmt:message key="header.main" /></a></li>
				<li class="nav__link"><a href="${pageContext.request.contextPath}/Controller?page=index"><fmt:message key="header.index" /></a></li>
				<li class="nav__link"><a href="${pageContext.request.contextPath}/Controller?page=customers_form"><fmt:message key="header.customers.form" /></a></li>
				<li class="nav__link"><a href="${pageContext.request.contextPath}/Controller?page=logout"><fmt:message key="header.logout" /></a></li>
				<li class="nav__link">
					<a id="ua" href="${pageContext.request.contextPath}/Controller?command=change_language&lang=ua">Укр</a>
					<a id="en" href="${pageContext.request.contextPath}/Controller?command=change_language&lang=en">Eng</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="nav__link"><a href="${pageContext.request.contextPath}/Controller?page=login"><fmt:message key="header.login" /></a></li>
				<li class="nav__link"><a href="${pageContext.request.contextPath}/Controller?page=customers_form"><fmt:message key="header.customers.form" /></a></li>
				<li class="nav__link"><a href="${pageContext.request.contextPath}/Controller?page=index"><fmt:message key="header.index" /></a></li>
				<li class="nav__link">
					<a href="${pageContext.request.contextPath}/Controller?command=change_language&lang=ua">Укр</a>
					<a href="${pageContext.request.contextPath}/Controller?command=change_language&lang=en">Eng</a>
				</li>
			</c:otherwise>
		</c:choose>
		</ul>
		</div>
	</div>
	<div class="page <c:if test="${param['page'] == 'index'}">hdd</c:if>">