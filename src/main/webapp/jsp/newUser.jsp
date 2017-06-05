<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <c:import url="header.jsp"></c:import>
  <c:import url="sidebar.jsp"></c:import>
  <div class="main">
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  	<label><fmt:message key="user.first.name" /></label><input type="text" name="first_name">
  	<label><fmt:message key="user.last.name" /></label><input type="text" name="last_name">
  	<label><fmt:message key="user.login" /></label><input type="text" name="login">
  	<label><fmt:message key="user.password" /></label><input type="text" name="password">
  	<label></label>
  	<select name="role_id">
  		<c:forEach items="${roles}" var="role">
  			<option value="${role.id}">${role.name}</option>
  		</c:forEach>
  	</select>
  	<input type="hidden" name="command" value="create_user">
  	<input type="submit" value="<fmt:message key="user.add.user" />">
  </form>
  </div> <!-- end page class -->
</body>
</html>