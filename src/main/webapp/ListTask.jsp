<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Css.jsp"></jsp:include>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Sidebar.jsp"></jsp:include>
	<div class="content-body">
		<div class="container-fluid">

			
			<!-- row -->


			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Pending Tasks</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="example" class="display" style="min-width: 845px">
									<thead>
										<tr>
											<!-- <th>Task Id</th> -->
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="it" items="${task }">
										<c:if test="${it.status =='pending'}">
											<tr>
												<%-- <td>${it.taskid }</td> --%>
												<td>${it.taskName}</td>
												<td>${it.taskDescription }</td>
												<td>${it.status}</td>
												<td>${it.prority}</td>
												<td>${it.startDate}</td>
												<td>${it.endDate}</td>
												<td>
													<a href="TaskDoneController?taskId=${it.taskid }" class="badge badge-success">
													Done
													</a>
													
													<a href="DeleteTaskController?taskId=${it.taskid }" class="badge badge-danger">
													delete
													</a>
													
													<a href="UpdateTaskController?taskId=${it.taskid }" class="badge badge-rounded badge-primary">Update</a>
												</td>
											</tr>
											</c:if>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<!-- <th>Task Id</th> -->
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Action</th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		

			
			<!-- row -->


			<div class="row">
				<div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Dane tasks</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="example5" class="display" style="min-width: 845px">
									<thead>
										<tr>
											<th>Task Id</th>
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="it" items="${task }">
										<c:if test="${it.status == 'done'}">
											<tr>
												<td>${it.taskid }</td>
												<td>${it.taskName}</td>
												<td>${it.taskDescription }</td>
												<td>${it.status}</td>
												<td>${it.prority}</td>
												<td>${it.startDate}</td>
												<td>${it.endDate}</td>
												
											</tr>
											</c:if>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>Task Id</th>
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>
										
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="Js.jsp"></jsp:include>
</body>
</html>