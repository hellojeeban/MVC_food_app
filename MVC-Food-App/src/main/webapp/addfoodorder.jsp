<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/common_js_css.jsp"%>
</head>
<body>
	${msg}
	<div class="container-fluid">
		<div class="row mt-5 bg-img">
			<div class="col-md-6 offset-md-3">
				<div class="card ms-4" style="width: 90%;">
					<div class="card-body">
						<h3 class="text-center">Login Form</h3>
						<form:form action="savefoodorder" modelAttribute="foodOrder">
							<div class="mb-3">
								<label for="email" class="form-label">Name</label>
								<form:input path="name" class="form-control" />
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Phone
									number</label>
									<form:input path="mobiilenum" class="form-control" />
							</div>
							<div class="container text-center mt-2">
								<button type="submit" class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-primary">Reset</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>