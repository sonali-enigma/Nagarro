package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Book;
import com.service.BookService;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	BookService displayBooks;
	@Autowired
	LoginService loginService;

	@PostMapping("/Login") // for post method mapping
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		// getting username and password
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		// function to check user exist or not

		if (loginService.checkLogin(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			List<Book> books= displayBooks.retrieveBooks();
			session.setAttribute("books", books);
			mv.setViewName("bookListing");

		} else {
			mv.setViewName("login");
		}
		return mv;
	}

}
