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
public class DeleteController {


	
	@Autowired
	BookService bookService;

	@PostMapping("/Delete") // for post method mapping
	public ModelAndView deleteBook(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		
		String bookCode = request.getParameter("bookCode");
		int bookcode=Integer.parseInt(bookCode);
		
		

		
		    bookService.deleteBook(bookcode);
			HttpSession session = request.getSession();
			List<Book> books= bookService.retrieveBooks();
			session.setAttribute("books", books);
			mv.setViewName("bookListing");

		
		
		return mv;
	}

}

