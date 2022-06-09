package com.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Product.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/save")
public class SaveProducts extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GETTING VALUES FROM FORM
		try {
			HttpSession sessionHttp = request.getSession();
			String uname = (String) sessionHttp.getAttribute("username");
			String title = request.getParameter("title");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int size = Integer.parseInt(request.getParameter("size"));

			Part file = request.getPart("image");
			int imagesize = (int) file.getSize();

			String imageFileName = file.getSubmittedFileName(); // get selected image file name

			String uploadPath = "C:\\Users\\sonaliprajapati\\eclipse-workspace\\ecommerceProduct\\src\\main\\webapp\\img\\"
					+ imageFileName; // upload path where we have to upload our actual image

			byte[] data;
//FOR STORING IMAGE
			
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();

			data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			is.close();
			fos.close();
			Product newProduct = new Product();
//CREATING OBJECT AND ADDING PRODUCT
			newProduct.setImage(data);
			newProduct.setQuantity(quantity);
			newProduct.setSize(size);
			newProduct.setTitle(title);
			newProduct.setUname(uname);
			newProduct.setImageSize(imagesize);

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
					.buildSessionFactory();
			Session session = factory.openSession();

			session.beginTransaction();

			session.save(newProduct);

			session.getTransaction().commit();
			session.close();

			response.sendRedirect("welcome.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
