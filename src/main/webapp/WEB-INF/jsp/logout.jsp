<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>
<c:url var="logoutUrl" value="/logout" />
<form action="${logoutUrl}" method="post">
	<input type="submit" value="Logout" /> <input type="hidden"
		name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>