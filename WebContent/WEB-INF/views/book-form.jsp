<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Book</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Book Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Book</h3>

		<form:form action="saveBook" modelAttribute="theBook" method="POST">

			<!-- need to associate this data with book id -->
			<form:hidden path="id" />
			<table>
				<tbody>

					<tr>
						<td>Title</td>
						<td><form:input path="title" /></td>
					</tr>

					<tr>
						<td>Year Public</td>
						<td><form:input path="yearPublic" /></td>
					</tr>

					<tr>
					<td>Category of Book</td>
					<td>
						<form:select path="category.id" name="subject">
							<option disabled="disabled" selected="selected">Choose
								category</option>
							<form:options items="${categorys}" itemLabel="name"
								itemValue="id" />
						</form:select>
						</td>
					</tr>
					
					<tr>
						<td><input type="submit" class="save" value="Save" /></td>
					</tr>


				</tbody>
			</table>
		</form:form>

		<p>
			<a href="${pageContext.request.contextPath}/book/list">Back
				to List</a>
		</p>

	</div>

</body>
</html>