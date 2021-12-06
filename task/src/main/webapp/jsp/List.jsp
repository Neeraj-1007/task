<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src='<c:url value="http://localhost:8080/resources/js/CheckBox.js"></c:url>'></script>
</head>
<body>
	<h1>User List</h1>

	<c:if test="${error!=null }">${error}</c:if>

	<c:if test="${success!=null }">	${success}</c:if>
	
	<c:url var="editUrl"
				value="/user/Register" /> <a
								href="${editUrl}">New Registration </a>

	<sf:form method="post" modelAttribute="form">

		<c:if test="${!empty list}">
			<sf:label path="firstName">${firstName}</sf:label>
			<sf:input path="firstName" placeholder="${firstName}" />

			<sf:label path="lastName">${lastName}</sf:label>
			<sf:input path="lastName" placeholder="${lastName}" />

			<sf:label path="pincode">${pincode}</sf:label>
			<sf:input path="pincode" placeholder="${pincode}" />

			<button type="submit" name="operation" value="Search">Search</button>
			<button type="submit" name="operation" value="Redirect">Reset</button>
			<button type="submit" name="operation" value="DOB">Sort(DOB)</button>

			
			<table>
				<thead class="c3">
					<tr>
						<th scope="col" class="text-center text-white"><input
							type="checkbox" id="selectall" />Mark As Delete</th>
						<th scope="col" class="text-center">Sno.</th>
						<th scope="col" class="text-center">FirstName</th>
						<th scope="col" class="text-center">LastName</th>
						<th scope="col" class="text-center">State</th>
						<th scope="col" class="text-center">City</th>
						<th scope="col" class="text-center">PhoneNo</th>
						<th scope="col" class="text-center">Pincode</th>
						<th scope="col" class="text-center">Edit</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="user" varStatus="ct">
						<tr>
							<td class="text-center"><input class="case" name="chk_1"
								type="checkbox" value="${user.id}"></td>
							<td class="text-center">${user.id}</td>
							<td class="text-center">${user.firstName}</td>
							<td class="text-center">${user.lastName}</td>
							<td class="text-center">${user.state}</td>
							<td class="text-center">${user.city}</td>
							<td class="text-center">${user.phoneNo}</td>
							<td class="text-center">${user.pincode}</td>
							<td class="text-center"><c:url var="editUrl"
									value="/user/Register?id=" /> <a
								href="${editUrl}${user.id}"> Edit</a></td>

							</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="submit" name="operation" value="Delete">Delete
			</button>
		</c:if>
		<c:if test="${empty list}">
			<button type="submit" name="operation" value="Back">Back</button>
		</c:if>

	</sf:form>




</body>
</html>