<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>

<div class="container">
	<h2>User Registration Form</h2>
	<form:form modelAttribute="user" class="form-horizontal">
		<c:if test="${param.success eq true }">
			<div class="alert alert-success">Registration Successfull !</div>
		</c:if>

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<form:input path="name" class="form-control" id="name"
					placeholder="Name" />
				<form:errors path="name" />

			</div>
		</div>

		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" class="form-control" id="email"
					placeholder="Email" />
				<form:errors path="email" />

			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<form:password path="password" class="form-control" id="password"
					placeholder="password" />
				<form:errors path="password" />


			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Save" class="btn btn-primary" />
			</div>
		</div>

	</form:form>


</div>