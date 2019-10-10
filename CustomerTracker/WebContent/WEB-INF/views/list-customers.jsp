<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship MANAGER</h2>
		</div>
		<div id="container">
			<div id="content">
				<button class="add-button"
					onclick="window.location.href='showFormForAdd'; return false;">Add
					Customer</button>
				<form:form action="search" method="GET">
					Search Customer: <input type="text" name="searchName"
						placeholder="Enter Name to Search" />
						<input type="submit" value="Search" class="add-button"/>
				</form:form>
				<table>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Address</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${customers}" var="customer">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id }"></c:param>
						</c:url>
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${customer.id }"></c:param>
						</c:url>
						<tr>
							<td>${customer.id }</td>
							<td>${customer.firstName }</td>
							<td>${customer.lastName }</td>
							<td>${customer.email }</td>
							<td><a href="${updateLink}">Update</a> |<a
								href="${deleteLink}"
								onclick="if(!(confirm('Are you sure wanna to delete'))) return false">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>