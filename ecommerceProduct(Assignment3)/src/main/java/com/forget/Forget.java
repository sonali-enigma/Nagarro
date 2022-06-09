package com.forget;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Forget")
public class Forget extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		ForgetDao dao = new ForgetDao();

		if (dao.checkLogin(uname, pass)) {

			response.sendRedirect("login.jsp");
		}

		else
			response.sendRedirect("ForgetPassword.jsp");
	}
}
