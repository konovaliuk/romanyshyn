<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
  <jsp:include page="header.jsp" />
  
  <form action="${pageContext.request.contextPath}/Controller" method="POST">
  <div class="form">
  	<div class="row"><label><fmt:message key="form.date" /></label><input type="datetime-local" name="offer_time" id="date" required></div>
  	<div class="row"><label><fmt:message key="form.from" /></label><input type="text" name="place_from" id="place_from" required></div>
  	<div class="row"><label><fmt:message key="form.to" /></label><input type="text" name="place_to" id="place_to" required></div>
  	<div class="row"><label><fmt:message key="form.passengers" /></label><input type="number" min="1" max="40" name="capacity" id="capacity" required value="2"></div>
  	<div class="row"><label for="cargo"><fmt:message key="form.cargo" /></label><input type="checkbox" name="cargo" id="cargo" value="with_cargo"></div>
  	<div class="row"><label><fmt:message key="form.price" /> $</label><input type="number" name="price" min="200" max="1200" step="100" id="price" required value="200"></div>
    <div class="row"><label><fmt:message key="form.email" /></label><input type="email" name="email" id="email" required></div>
    <div class="row"><label><fmt:message key="form.phone" /></label><input type="text" name="phone" id="phone" required></div>
    <div class="row"><label><fmt:message key="form.first.name" /></label><input type="text" name="first_name" id="first_name" required></div>
    <div class="row"><label><fmt:message key="form.last.name" /></label><input type="text" name="last_name" id="last_name" required></div>
    <input type="hidden" name="command" value="create_offer">
    <div class="row"><input type="submit" value="<fmt:message key="form.make.order" />"></div>
     </div>
  </form> 
 
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/aj.js"></script>
</body>
</html>