package com.login;

import java.io.IOException;

import com.login.dao.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	 
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		LoginDao dao = new LoginDao();
		
		if(dao.checkLogin(uname, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("username",uname);
			response.sendRedirect("welcome.jsp"); 
		}
		
		else
			response.sendRedirect("login.jsp"); 
	}
	

	

}
