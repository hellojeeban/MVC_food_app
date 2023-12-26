<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/common_js_css.jsp"%>
</head>
<body>
	${msg}
	<div class="container mt-4">
		<div class="container-fluid">
			<div class="row">
				<div class="card md-3" style="width: 18rem">
					<div class="card-body">
						<a href="addUser"><h1>Add User</h1></a>
					</div>
				</div>
				<div class="card md-3" style="width: 18rem">
					<div class="card-body">
						<a href="validateform"><h1>login User</h1></a>
					</div>
				</div>
				<div class="card md-3" style="width: 18rem">
					<div class="card-body">
						<a href="addproduct"><h1>Add Product</h1></a>
					</div>
				</div>
				<div class="card md-3" style="width: 18rem">
					<div class="card-body">
						<a href="viewproduct"><h1>View Product</h1></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>