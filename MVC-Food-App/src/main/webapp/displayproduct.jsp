<%@page import="com.jsp.foodapp.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product here</title>
<%@include file="components/common_js_css.jsp"%>
</head>
<body>
${msg}
	<div class="container mt-3">
		<div class="container-fluid card">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ProductID</th>
						<th scope="col">Product Name</th>
						<th scope="col">Product Type</th>
						<th scope="col">Product Cost</th>
						<th scope="col">Product Update</th>
						<th scope="col">Product Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${allproducts}">
						<tr>
							<td>${product.getId()}</td>
							<td>${product.getName()}</td>
							<td>${product.getType()}</td>
							<td>${product.getCost()}</td>
							<td><a href="update?id=${product.getId()}">Update</a></td>
							<td><a href="deleteproduct?id=${product.getId()}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>