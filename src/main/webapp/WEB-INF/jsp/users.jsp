<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>
<div class="container">
	<h2>Users info</h2>
	<div class="table-responsive">
		<!-- 		<table class="table table-bordered table-hover table-striped"> -->
		<table class="table table-hover table-bordered table-striped">
			<thead>
				<tr class="success">
					<th>User name</th>
				</tr>

			</thead>
			<tbody>
				<tr>
					<c:forEach items="${users }" var="user">
						<tr>
							<td>
							<a href="<spring:url value='/users/${user.id}'/>">


									${user.name} </a></td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>


		</table>
	</div>
</div>