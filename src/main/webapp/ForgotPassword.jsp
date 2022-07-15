<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Css.jsp"></jsp:include>
</head>
<body class="vh-100" data-typography="poppins" data-theme-version="light" data-layout="vertical" data-nav-headerbg="color_1" data-headerbg="color_1" data-sidebar-style="full" data-sibebarbg="color_1" data-sidebar-position="fixed" data-header-position="fixed" data-container="wide" direction="ltr" data-primary="color_1">
    <div class="authincation h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100 align-items-center">
                <div class="col-md-6">
                    <div class="authincation-content">
                        <div class="row no-gutters">
                            <div class="col-xl-12">
                                <div class="auth-form">
									<div class="text-center mb-3">
										<a href="index.html"><img src="images/logo-full.png" alt=""></a>
									</div>
                                    <h4 class="text-center mb-4">Forgot Password</h4>
                                    <form action="ForgotPasswordController" method="post">
                                        <div class="mb-3">
                                            <label class="mb-1"><strong>Email</strong></label>
                                            <input type="email" name="email" class="form-control" placeholder="hello@example.com">
                                        </div>
                                        <label class="mb-1"><strong>Select Security Que.</strong></label>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="que"
												value="What is your addhar card last 4 disit?"> <label class="form-check-label">
												What is your addhar card last 4 disit?</label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="que"
												value="What is your mother name?"> <label class="form-check-label">
												What is your mother name? </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="que"
												value="Which is your favorite book?"> <label class="form-check-label">
												Which is your favorite book? </label>
										</div>
                                        
                                        <div class="mb-3">
											<label class="mb-1"><strong>Answer</strong></label> <input
												type="password" class="form-control"
												placeholder="answer" name="answer">
										</div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-primary btn-block">Submit</button>
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

</body>
</html>