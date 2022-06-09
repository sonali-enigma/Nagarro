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
<title>WELCOME</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>

<body>

<!-- to prevent access before login and to prevent going back after logout-->
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

	if (session.getAttribute("username") == null)
		response.sendRedirect("login.jsp");
	%>


	<div class="container-fluid">
		<div class="fixed-header">
			<div id="title" style="text-align: right;">

				<form action="Logout" method="post">
					Hi ${username} <input type="submit" value="Logout">
				</form>
			</div>
			<div id="title" style="text-align: center;">
				<h1 style="background-color:DodgerBlue;">Product Management Tool</h1>
			</div>
			<b>Please Enter Product Details To Enter To Stock</b>
		</div>
		<div class="row">

			<div class="main-content col-6">
				<form action="save" method="post" enctype="multipart/form-data">
					<div class="mb-3 row">
						<label for="Title" class="col-2">Title</label> <input type="text"
							class="col-4" id="Title" name="title">

					</div>
					<div class="mb-3 row">
						<label for="Quantity" class="col-2">Quantity</label> <input
							type="text" class="col-4" id="Quantity" name="quantity">

					</div>
					<div class="mb-3 row">
						<label for="Size" class="col-2">Size</label> <input type="text"
							class="col-4" id="Size" name="size">

					</div>
					<div class="mb-3 row">
						<label for="Image" class="col-2">Image</label> <input type="file"
							id="image" class="col-4" name="image"
							accept="image/x-png,image/gif,image/jpeg,image/jpg">


					</div>


					<div class="col-12">
						<button type="submit" class="btn btn-outline-success">SAVE</button>

					</div>
				</form>
			</div>

		</div>

<!-- table creation -->
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Title</th>
					<th scope="col">Quantity</th>
					<th scope="col">Size</th>
					<th scope="col">Image</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			
<!--display data from database -->
				<%
				SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Product.class)
						.buildSessionFactory();
				Session session2 = factory.openSession();

				String uname = session.getAttribute("username").toString();
				Query query;

				query = session2.createQuery("from Product where uname=:uname");

				query.setParameter("uname", uname);

				List<Product> products = (List<Product>) query.list();

				int i = 1;
				int totalSize=0;
				for (Product product : products) {
					totalSize+=product.getImageSize();
				%>
				<tr>
					<th scope="row"><%=i++%></th>

					<td><%=product.getTitle()%></td>
					<td><%=product.getQuantity()%></td>
					<td><%=product.getSize()%></td>
					<td><img src="image.jsp?title=<%=product.getTitle()%>"
						height="200px" width="200px"
						style="display: block; margin: 0 auto;" /></td>
					<td><a
						href="EditProduct.jsp?title=<%=product.getTitle()%>&quantity=<%=product.getQuantity()%>&size=<%=product.getSize()%> "
						class="  text-info ">EDIT</a>/ <a
						href="DeleteProduct?title=<%=product.getTitle()%>" class="  text-info ">DELETE
					</a></td>
				</tr>
				</td>
				<%
				}
				%>
			</tbody>
		</table>
		<%=totalSize/1000000%>MB
</body>


<!-- validation for image size not exceed above 1MB -->
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