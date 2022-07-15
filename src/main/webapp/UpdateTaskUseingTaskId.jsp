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
<body class="vh-100" data-typography="poppins" data-theme-version="light" data-layout="vertical" data-nav-headerbg="color_1" data-headerbg="color_1" data-sidebar-style="full" data-sibebarbg="color_1" data-sidebar-position="fixed" data-header-position="fixed" data-container="wide" direction="ltr" data-primary="color_1">
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Sidebar.jsp"></jsp:include>
    <div class="authincation h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100 align-items-center">
                <div class="col-md-6">
                    <div class="authincation-content">
                        <div class="row no-gutters">
                            <div class="col-xl-12">
                                <div class="auth-form">
									
                                    <h4 class="text-center mb-4">Update Task</h4>
                                    <form action="SubmitUpdateTaskController" method="post">
                                        <div class="mb-3">
                                            <label class="mb-1"><strong>Task Name</strong></label>
                                            ${taskId}
                                            <input type="text" name="taskId" hidden="" value="${taskId}">
                                            <input type="text" name="taskName" class="form-control" placeholder="hello@example.com" value="${taskBean.taskName }">
                                        </div>
                                        <div class="mb-3">
                                            <label class="mb-1"><strong>Task Description</strong></label>
                                            <input type="text" name="taskDescription" class="form-control" value="${taskBean.taskDescription }">
                                        </div>
                                        
                                        <label class="mb-1"><strong>Set Prority</strong></label>
                                        
										<div class="form-check">
										
											<input class="form-check-input" type="radio" name="prority"
												value="high"> <label class="form-check-label">
												High</label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="prority"
												value="mediun"> <label class="form-check-label">
												Mediun </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="prority"
												value="low"> <label class="form-check-label">
												Low </label>
										</div>
										
										
										  <div class="mb-3">
                                            <label class="mb-1"><strong>End Date</strong></label>
                                            <input type="date" name="endDate" class="form-control" value="${taskBean.endDate }">
                                        </div>
                                        <div class="row d-flex justify-content-between mt-4 mb-2">
                                            <span class="badge badge-danger text-white badge-sm float-end">${InvalidUser}</span>
                                        </div>
                                        <div class="text-center">
                                            <input type="submit" class="btn btn-primary btn-block" value="Submit"/>
                                        </div>
                                    </form>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


   <jsp:include page="Js.jsp"></jsp:include>

<jsp:include page="Js.jsp"></jsp:include>
</body>
</html>