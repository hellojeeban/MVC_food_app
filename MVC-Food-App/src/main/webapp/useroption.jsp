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
				<div class="card md-4" style="width: 18rem">
					<div class="card-body">
						<a href="addfoodOrder"><h1 class="text-center">Order Food</h1></a>
					</div>
				</div>
				<div class="card md-4" style="width: 18rem">
					<div class="card-body">
						<a href="viewallorder"><h1 class="text-center">View All Food Orders</h1></a>
					</div>
				</div>
				<div class="card md-4" style="width: 18rem">
					<div class="card-body">
						<a href="viewprofile"><h1>View Profile</h1></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>