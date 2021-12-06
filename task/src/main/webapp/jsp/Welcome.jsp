<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Hello</h1>

	
	<h1>${name}</h1>
	<table>
		<tbody>
			<c:forEach items="${list}" var="role" varStatus="ct">
				<tr>
					<td class="text-center">${role.id}</td>
				
					<td class="text-center">${role.name}</td>
				
					
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>