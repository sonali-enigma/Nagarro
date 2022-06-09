<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.entity.Tshirt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>result</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


</head>
<body>


	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	<div class="fixed-header">
		<div id="title" style="text-align: right;">

			<form action="Logout" method="post">
				<b>Hi ${username} <input type="submit"
					class="btn btn-outline-success" value="Logout">
			</form>
			<div id="title" style="text-align: center;">
				<h1 style="background-color: lightyellow;">
					<a href="welcome.jsp"> SEARCH MORE TSHIRTS!! </a>
				</h1>
			</div>




		</div>
		<c:if test="${result.size() != 0}">
			<header>
				<div>
					<table width="100%">
						<tr>
							<td>
								<h2>
									<div id="title" style="text-align: center;">
										<h1 style="background-color: lightpink;">
											<c:out value="${result.size()}"></c:out>
											Matching Tshirts found!
										</h1>
									</div>
								</h2>
							</td>

						</tr>
					</table>
				</div>
			</header>
			<!-- table creation -->
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">NAME</th>
						<th scope="col">COLOUR</th>
						<th scope="col">GENDER</th>
						<th scope="col">SIZE</th>
						<th scope="col">PRICE</th>
						<th scope="col">RATING</th>
						<th scope="col">AVAILABILITY</th>

					</tr>
				</thead>
				<tbody>

					<!--display data from database -->
					<c:forEach items="${result}" var="Tshirt">
						<tr>


							<td>${Tshirt.getID()}</td>
							<td>${Tshirt.getName()}</td>
							<td>${Tshirt.getColour()}</td>
							<td>${Tshirt.getGender()}</td>
							<td>${Tshirt.getSize()}</td>
							<td>${Tshirt.getPrice()}</td>
							<td>${Tshirt.getRating()}</td>
							<td>${Tshirt.getAvailability()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${result.size() == 0}">
			<header>
				<div>
					<table width="100%">
						<tr>
							<td>
								<h2>Sorry! No matching Tshirts found!</h2>
							</td>

						</tr>
					</table>
				</div>
			</header>
		</c:if>
		<br>
</body>
</html>