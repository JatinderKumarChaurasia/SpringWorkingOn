<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Landing Page</title>
</head>
<body>
	<h2>Landing Page</h2>
	<hr>
	<p>Welcome to the landing page! This page is open to the public ...
		no login required :-)</p>
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/employees">Access
			Secure Site (requires login)</a>
	</p>
</body>
</html>