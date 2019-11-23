<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Book</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Book Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<a href="<c:url value='/book/addBook' />"> <input
				class="add-button" type="button" value="Add Book" />
			</a>

			<!-- SEARCH BOX -->
			<form:form action="search" method="GET">
            
                Search Book: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />

			</form:form>
			<!-- SEARCH BOX -->


			<table>
				<tr>
					<th>Title</th>
					<th>Year Public</th>
					<th>Category</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="book" items="${listBooks}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/book/update">
						<c:param name="bookId" value="${book.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/book/delete">
						<c:param name="bookId" value="${book.id}" />
					</c:url>

					<tr>
						<td>${book.title}</td>
						<td>${book.yearPublic}</td>
						<td>${book.category.name}</td>

						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if (!(confirm('Are you sure want to delete this book?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</div>






</body>
</html>