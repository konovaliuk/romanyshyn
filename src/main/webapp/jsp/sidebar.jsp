<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <div class="sidebar">
  	<c:choose>
  		<c:when test="${sessionScope.user.role.name == 'driver'}">
  			<a class="item" <c:if test="${param.page == 'driver_offer'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=driver_offer"><fmt:message key="sidebar.work" /></a>
  			<a class="item" <c:if test="${param.page == 'main'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=main"><fmt:message key="sidebar.main" /></a>
  		</c:when>
  		<c:when test="${sessionScope.user.role.name == 'dispatcher'}">
  			<a class="item" <c:if test="${param.page == 'cars' || param.page == 'car'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=cars"><fmt:message key="sidebar.cars" /></a>
			<a class="item" <c:if test="${param.page == 'drivers' || param.page == 'driver'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=drivers"><fmt:message key="sidebar.drivers" /></a>
			<a class="item" <c:if test="${param.page == 'offers' || param.page == 'offer'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=offers"><fmt:message key="sidebar.offers" /></a>
			<a class="item" <c:if test="${param.page == 'main'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=main"><fmt:message key="sidebar.main" /></a>
  		</c:when>
  		<c:otherwise>
  			<a class="item" <c:if test="${param.page == 'main'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=main"><fmt:message key="sidebar.main" /></a>
  			<a class="item" <c:if test="${param.page == 'new_user'}">id="active_link"</c:if> href="${pageContext.request.contextPath}/Controller?page=new_user"><fmt:message key="sidebar.new.user" /></a>
  		</c:otherwise>
  	</c:choose>
  </div>