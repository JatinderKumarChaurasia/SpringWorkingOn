<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Login Page</title>

<link type="text/css" rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js">
	
</script>
</head>
<body>
	<div id="login-box" style="margin-top: 50px"
		class="col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign In</div>
			</div>
			<div class="panel-body" style="padding-top: 30px">
				<form:form
					action="${pageContext.request.contextPath}/authenticateTheUser"
					method="POST" class="form-horizontal">
					<div class="form-group">
						<div class="col-xs-15">
							<div>
								<c:if test="${param.error != null }">
									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										<i style="color: red">You Have Entered Wrong userName or
											Password</i>
									</div>
								</c:if>
								<c:if test="${param.logout != null }">
									<div class="alert alert-success col-xs-offset-1 col-xs-10">
										You are Logout</div>
								</c:if>
							</div>
						</div>
					</div>
					<div class="input-group" style="margin-bottom: 25px">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="password"
							placeholder="Enter Your Username" name="username"
							class="form-control" />
					</div>
					<div class="input-group" style="margin-bottom: 25px">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="password"
							placeholder="Enter Your Password" name="password"
							class="form-control" />
					</div>
					<div style="margin-top: 10px" class="form-group">
						<div class="col-sm-6 controls">
							<button type="submit" class="btn btn-success" value="Login">Login</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- 	<script type="text/javascript"
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->

</body>
</html>