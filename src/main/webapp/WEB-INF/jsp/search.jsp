<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<h2>Search Record</h2>
		<br />

		<form:form action="search" method="post" modelAttribute="bean">
				Enter State: <form:input path="state" />
				
			|&|	Enter Course: <form:input path="course" />

			<input type="submit" value="search">
		</form:form>
		<table border="2" width="100%">
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
				
				<th>Action</th>
			</tr>
			<c:forEach var="tab" items="${data }">
				<form action="edit" method="post" modelAttribute="bean">
					<tr>
						<td><input type="text" name="enrollment_id"
							value="${tab.enrollment_id }"></td>

						<td><input type="text" name="first_name"
							value="${tab.first_name }"></td>


						<td><input type="text" name="last_name"
							value="${tab.last_name }"></td>


						<td><input type="text" name="gender" value="${tab.gender }"></td>
						<td><input type="text" name="dob" value="${tab.dob }"></td>
						<td><input type="text" name="state" value="${tab.state }"></td>
						<td><input type="text" name="marks" value="${tab.marks }"></td>
						<td><input type="text" name="course" value="${tab.course }"></td>
						<td><input type="text" name="doa" value="${tab.doa }"></td>

						<td align="center"><input type="submit" value="update">
				</form>
				</td>


				<td align="center">
					<form action="delete" method="post" modelAttribute="bean">
						<input type="hidden" value="${tab.enrollment_id}"
							name="enrollment_id">
						<td align="center"><input type="submit" value="Delete">
						</td>
						</tr>
			</c:forEach>
		</table> 
		<h2>${msg }</h2>
	</center>
</body>
</html>