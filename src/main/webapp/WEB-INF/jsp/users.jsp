<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('.triggerRemove').click(function(e) {
			e.preventDefault();
			$("#modelRemove .removeBtn").attr("href", $(this).attr("href"));
			$("#modelRemove").modal();
		});
	})
</script>
<div class="container">
	<c:if test="${param.success eq true }">
		<div class="alert alert-success">User Remove Successfully !</div>
	</c:if>


	<h2>Users info</h2>
	<div class="table-responsive">
		<!-- 		<table class="table table-bordered table-hover table-striped"> -->
		<table class="table table-hover table-bordered table-striped">
			<thead>
				<tr class="success">
					<th>User name</th>
					<th>Action</th>
				</tr>

			</thead>
			<tbody>
				<tr>
					<c:forEach items="${users }" var="user">
						<tr>
							<td><a href="<spring:url value='/users/${user.id}'/>">


								<c:out value="${user.name}"/> </a></td>
							<td><a href='<spring:url value="/users/remove/${user.id}"/>'
								class="btn  btn-danger pull-right triggerRemove"> <span
									class="glyphicon glyphicon-remove"> Remove user</span>
							</a></td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>


		</table>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="modelRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Remove User</h4>
			</div>
			<div class="modal-body">Are you sure to remove this user?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href="" class="btn btn-danger removeBtn">Remove</a>
			</div>
		</div>
	</div>
</div>
