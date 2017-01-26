<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>

<div class="container">
	<h2>User Detail Info</h2>
	<h3>${user.name}</h3>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal">New Blog</button>

	<form:form modelAttribute="blog" class="form-horizontal">
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">New Blog</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<form:input path="name" class="form-control" id="name"
									placeholder="Name" />

							</div>
						</div>

						<div class="form-group">
							<label for="url" class="col-sm-2 control-label">URL</label>
							<div class="col-sm-10">
								<form:input path="url" class="form-control" id="url"
									placeholder="url" />

							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="submit" class="btn btn-primary" value="Save" />

					</div>
				</div>
			</div>
		</div>
	</form:form>
	<br /> <br />
	<script type="text/javascript">
	$(document).ready(function(){
		$('.nav-tabs a:first').tab('show'); // Select first tab
	})
	</script>
	
	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">

		<c:forEach items="${user.blogs}" var="blog">

			<li><a href="#blog_${blog.id}" aria-controls="home" role="tab"
				data-toggle="tab">${blog.name }</a></li>

		</c:forEach>

	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">

			<div role="tabpanel" class="tab-pane" id="blog_${blog.id}">
				<h4>${blog.name}</h4>
				<h4>${blog.url}</h4>
				<div class="table-responsive">
					<!-- 		<table class="table table-bordered table-hover table-striped"> -->
					<table class="table table-hover table-bordered table-striped">
						<thead>
							<tr class="success">
								<th>Title</th>
								<th>Link</th>
							</tr>

						</thead>
						<tbody>
							<tr>
								<c:forEach items="${blog.items}" var="item">
									<tr>

										<td>${item.title}</td>
										<td>${item.link}</td>

									</tr>
								</c:forEach>
							</tr>
						</tbody>


					</table>
				</div>

			</div>
		</c:forEach>
	</div>

</div>