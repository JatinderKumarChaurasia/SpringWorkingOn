<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

</head>
<body>
	<div class="container jumbotron mt-4">
		<div class="card" style="width: 25rem">
			<div class="card-header">
				<div class="card-title">
					<p class="display-4">Register Yourself</p>
				</div>
			</div>
			<div class="container card-body" style="padding-top: 30px">
				<div class="form-horizontal">
					<form:form
						action="${pageContext.request.contextPath}/register/processRegistration"
						modelAttribute="crmUser" method="POST">
						<div class="form-group">
							<div class="col-xs-15">
								<c:if test="${registrationError != null }">
									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										${registrationError}</div>
								</c:if>
							</div>
						</div>
						<div class="input-group m-1">
							<div class="input-group-prepend p-2 w-50">
								<p>UserName</p>
								<form:errors path="username" cssClass="error" />
							</div>
							<form:input path="username" type="text" class="form-control"
								placeholder="Enter Your Username" name="username" />
						</div>
						<div class="input-group m-1">
							<div class="input-group-prepend p-2 w-50">
								<p>Password</p>
								<form:errors path="password" cssClass="error" />
							</div>
							<form:password path="password" class="form-control"
								placeholder="Enter Your Password" name="password" />
						</div>
						<div class="input-group m-1">
							<div class="input-group-prepend p-2 w-50">
								<p>Confirm Password</p>
								<form:errors path="matchingPassword" cssClass="error" />
							</div>
							<form:password path="matchingPassword" class="form-control"
								placeholder="Confirm Password" name="matchingPassword" />
						</div>
						<div class="input-group m-1">
							<div class="input-group-prepend p-2 w-50">
								<p>First Name</p>
								<form:errors path="firstname" cssClass="error" />
							</div>
							<form:input path="firstname" type="text" class="form-control"
								placeholder="Enter Your First Name" name="firstname" />
						</div>
						<div class="input-group m-1">
							<div class="input-group-prepend p-2 w-50">
								<p>Last Name</p>
								<form:errors path="lastname" cssClass="error" />
							</div>
							<form:input path="lastname" type="text" class="form-control"
								placeholder="Enter Your Last Name" name="lastname" />
						</div>
						<div class="input-group m-1">
							<div class="input-group-prepend p-2 w-50">
								<p>Email</p>
								<form:errors path="email" cssClass="error" />
							</div>
							<form:input path="email" type="text" class="form-control"
								placeholder="Enter Your Email" name="email" />
						</div>
						<div class="input-group m-1">
							<div class="input-group-prepend p-2 w-50">
								<p>Role</p>
								<form:errors path="userRole" cssClass="error" />
							</div>
							<form:select path="userRole" items="${roles}"
								class="form-control" />
						</div>
						<div style="margin-top: 19px" class="form-group">
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>