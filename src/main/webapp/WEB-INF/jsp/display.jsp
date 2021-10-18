<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<center>
		<table border=1>
			<tr>
				<th>Enrollment id</th>
				<th>First_Name</th>
				<th>Last_Name</th>
				<th>Gender</th>
				<th>DOB</th>
				<th>State</th>
				<th>Marks</th>
				<th>Course</th>
				<th>DOA</th>
			</tr>

			<c:forEach var="tab" items="${data}">

				<tr>
					<td>${ tab.enrollment_id }</td>
					<td>${ tab.first_name }</td>
					<td>${ tab.last_name }</td>
					<td>${ tab.gender }</td>
					<td>${ tab.dob }</td>
					<td>${ tab.state}</td>
					<td>${ tab.marks }</td>
					<td>${ tab.course }</td>
					<td>${ tab.doa }</td>

				</tr>
			</c:forEach>

		</table>
	</center>
</body>
</html>