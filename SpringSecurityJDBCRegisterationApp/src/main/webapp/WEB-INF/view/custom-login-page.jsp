<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Login Page</title>
</head>
<body>
	<h3>Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<c:if test="${param.error!=null }">
			<i style="color: red">You Have Entered Wrong userName or Password</i>
		</c:if>
		<p>
			UserName : <input type="text" placeholder="Enter Your UserName"
				name="username" />
		</p>
		<p>
			Password : <input type="password" placeholder="Enter Your Password"
				name="password" />
		</p>
		<button type="submit" value="Login">Login</button>
	</form:form>
</body>
</html>