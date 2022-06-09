<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.Product.Product"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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

	if (session.getAttribute("username") == null)
		response.sendRedirect("login.jsp");
	%>

	<div class="row">
		<div id="title" style="text-align: center;">
			<h1  style="background-color:DodgerBlue;">Product Management Tool</h1>
		</div>
		<div class="main-content col-6">
			<form action="Edit" method="post" enctype="multipart/form-data">
				<div class="mb-3 row">
					<label for="Title" class="col-2 mx-4">Title</label> <input type="text"
						class="col-4" id="Title"
						value="<%=request.getParameter("title")%>" name="title" readonly>

				</div>
				<div class="mb-3 row">
					<label for="Quantity" class="col-2 mx-4">Quantity</label> <input
						type="text" class="col-4" id="Quantity"
						value="<%=request.getParameter("quantity")%>" name="quantity">

				</div>
				<div class="mb-3 row">
					<label for="Size" class="col-2 mx-4">Size</label> <input type="text"
						class="col-4" id="Size" value="<%=request.getParameter("size")%>"
						name="size">

				</div>
				<div class="mb-3 row">
					<label for="Image" class="col-2 mx-4">Image</label> <input type="file"
						id="image" class="col-4" name="image"
						accept="image/x-png,image/gif,image/jpeg,image/jpg">


				</div>


				<div class="col-12 mx-4">
					<button type="submit" class="btn btn-outline-success">SAVE</button>

				</div>
			</form>
		</div>

	</div>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		maxfilesize = 1 * 1024 * 1024; //1mb
		$("#image").change(function() {
			fileSize = this.files[0].size;
			if (fileSize > maxfilesize) {
				this.setCustomValidity("Upload Image Size Less Than 1 MB");
				this.reportValidity();
			} else {
				this.setCustomValidity();
			}
		});
	});
</script>
</html>