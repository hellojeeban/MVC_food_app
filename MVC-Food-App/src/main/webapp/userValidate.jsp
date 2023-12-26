<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/common_js_css.jsp" %>
</head>
<body>
${msg}
<div class="container-fluid">
		<div class="row mt-5 bg-img">
			<div class="col-md-6 offset-md-3">
				<div class="card ms-4" style="width: 90%;">
					<div class="card-body">
						<h3 class="text-center">Login Form</h3>
						<form action="uservalidate" method="post">
							<div class="mb-3">
								<label for="email" class="form-label">Email
									address</label> 
									<input type="email" class="form-control" name="email" required="required"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" name="password" required="required"
									id="exampleInputPassword1">
							</div>
							<div class="container text-center mt-2">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-primary">Reset</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>