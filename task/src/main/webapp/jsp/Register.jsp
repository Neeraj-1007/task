<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href='<c:url value = "https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"></c:url>'>
<script
	src='<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></c:url>'></script>
<script
	src='<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></c:url>'></script>
<script
	src='<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></c:url>'></script>
<script
	src='<c:url value="http://localhost:8080/resources/js/CheckBox.js"></c:url>'></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			yearRange : '1970:2030',
			dateFormat : 'dd/mm/yy',
			endDate : '-18y'
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>





	<div class="row">

		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-body">
					<sf:form method="post" modelAttribute="form">
						<table>
							<tr style="text-align: center;">Register User
							</tr>


							<tr>
								<th><sf:label path="firstName">
							First Name
						</sf:label></th>
								<th><sf:input path="firstName" /></th>
								<th><sf:errors path="firstName">${errorfirstName}</sf:errors></th>
							</tr>
							<br>


							<tr>
								<th><sf:label path="lastName">
							Last Name
						</sf:label></th>
								<th><sf:input path="lastName" /></th>
								<th><sf:errors path="lastName"></sf:errors></th>
							</tr>
							<tr>
								<th><sf:label path="gender">
						Gender
						</sf:label></th>
								<th><sf:input path="gender" /></th>
								<th><sf:errors path="gender"></sf:errors></th>
							</tr>
							<br>
							<tr>
								<th><sf:label path="phoneNo">
							PhoneNo
						</sf:label></th>
								<th><sf:input path="phoneNo" /></th>
								<th><sf:errors path="phoneNo"></sf:errors></th>
							</tr>
							<br>


							<tr>
								<th><sf:label path="city">
							City
						</sf:label></th>
								<th><sf:input path="city" /></th>
								<th><sf:errors path="city"></sf:errors></th>
							</tr>
							<br>
							<tr>
								<th><sf:label path="state">
							State
						</sf:label></th>
								<th><sf:input path="state" /></th>
								<th><sf:errors path="state"></sf:errors></th>
							</tr>
							<br>

							<tr>
								<th><sf:label path="pincode">
							Pincode
						</sf:label></th>
								<th><sf:input path="pincode" /></th>
								<th><sf:errors path="pincode"></sf:errors></th>
							</tr>
							<br>

							<tr>
								<th><sf:label path="dob">
							DOB
						</sf:label></th>
								<th><sf:input path="dob" id="datepicker" /></th>
								<th><sf:errors path="dob"></sf:errors></th>
							</tr>
							<br>
							<c:choose>
								<c:when test="${form.id>0}">
									<tr>
										
										<th><button type="submit" name="operation" value="UPDATE">update</button></th>
										<th><button type="submit" name="operation" value="LIST">list</button></th>
									</tr>

									</c:when>
									<c:otherwise>
										<tr>
											
											<th><button type="submit" name="operation" value="SAVE">save</button></th>
											<th><button type="submit" name="operation"
													value="CANCEL">cancel</button></th>
										</tr>
									</c:otherwise>
							</c:choose>
						</table>
					</sf:form>

				</div>
			</div>



		</div>
		<div class="col-md-4"></div>
	</div>


</body>
</html>