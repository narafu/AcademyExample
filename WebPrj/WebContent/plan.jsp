<%@page import="review.example.Plan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	text-align: center;
}

dt, dd {
	display: inline;
	margin: 0px
}

div {
	margin-top: 30px; display : flex;
	justify-content: center;
	display: flex;
}

th, td {

	width : 100px;
}
</style>
<title>Plan</title>
</head>
<body>

	<header>
		<h1>Study Plan</h1>
		<div>
			<dt>기간 :</dt>
			<dd>2020.04.30~2020.05.05(6days)</dd>
		</div>
	</header>

	<main>
		<div>
			<table border="1px">
				<tr>
					<th>No</th>
					<th>Day</th>
					<th>Subject</th>
					<th>Date</th>
					<th>Ordinal</th>
				</tr>
				<c:forEach var="n" items="${list }">
					<tr>
						<td>${n.num}</td>
						<td>${n.day}</td>
						<td>${n.subject}</td>
						<td>${n.date }</td>
						<td>${n.ordinal }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>

	<footer> </footer>



</body>
</html>