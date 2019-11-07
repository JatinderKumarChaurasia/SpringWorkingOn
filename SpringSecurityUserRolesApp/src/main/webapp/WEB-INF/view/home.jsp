<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h2>Company Home Page</h2>
	<hr />
	<p>Welcome To Home Page! jwdjj</p>
	<hr />
	<p>
		Username :
		<security:authentication property="principal.username" />
		<br /> Role :
		<security:authentication property="principal.authorities" />
	</p>
	<hr />
	<p>
	<a href="${pageContext.request.contextPath }/leaders">Leadership Meeting</a>
	Only For Managers
	</p>
	<p>
	<a href="${pageContext.request.contextPath }/systems">Admin Meeting</a>
	Only For Admin
	</p>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>