package com.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//GETTING VALUES FROM FORM

		try {
			HttpSession sessionHttp = request.getSession();
			String uname = (String) sessionHttp.getAttribute("username");
			String title = request.getParameter("title");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int size = Integer.parseInt(request.getParameter("size"));
			boolean flag = true;
			Part file = request.getPart("image");
			int imagesize = (int) file.getSize();
			byte[] data = null;

			// CHECKING IF THERE NEW IMAGE UPLOADED OR NOT
			if (imagesize == 0)
				flag = false;
			else {
				String imageFileName = file.getSubmittedFileName(); // get selected image file name

				String uploadPath = "C:\\Users\\sonaliprajapati\\eclipse-workspace\\ecommerceProduct\\src\\main\\webapp\\img\\"
						+ imageFileName; // upload path where we have to upload our actual image

				FileOutputStream fos = new FileOutputStream(uploadPath);
				InputStream is = file.getInputStream();

				data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				is.close();
				fos.close();

				// to check that limit for all products NOT cross 10mb
				SessionFactory factory1 = new Configuration().configure("hibernate2.cfg.xml")
						.addAnnotatedClass(Product.class).buildSessionFactory();
				Session session3 = factory1.openSession();

				session3.beginTransaction();

				Query searchQuery2 = session3.createQuery("from Product where username=:username");
				searchQuery2.setParameter("username", uname);
				List<Product> products = searchQuery2.list();
				int totalSize = 0;
				for (Product product : products) {
					totalSize = totalSize + product.getImageSize();
				}
				if (totalSize != 0) {

					int finalSize = totalSize + imagesize;
					if (finalSize > 10 * 1024 * 1024) {
						session3.getTransaction().commit();
						session3.close();
						response.sendRedirect("welcome.jsp");
						return;
					}

					session3.getTransaction().commit();
					session3.close();
				}
			}

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
					.buildSessionFactory();
			Session session = factory.openSession();

			session.beginTransaction();

			// IF NEW IMAGE UPLOADED THEN
			if (flag) {
				Query searchQuery = session.createQuery(
						"update Product set quantity=:quantity,size=:size,image=:image imagesize=:imageSize where title=:title");
				searchQuery.setParameter("quantity", quantity);
				searchQuery.setParameter("size", size);
				searchQuery.setParameter("image", data);
				searchQuery.setParameter("title", title);
				searchQuery.setParameter("imageSize", imagesize);
				
				searchQuery.executeUpdate();

			}
			// IF NO IMAGE UPLOADED THEN
			else {
				Query searchQuery = session
						.createQuery("update Product set quantity=:quantity,size=:size where title=:title");
				searchQuery.setParameter("quantity", quantity);
				searchQuery.setParameter("size", size);
				searchQuery.setParameter("title", title);
				searchQuery.executeUpdate();
			}

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("welcome.jsp");
	}

}
