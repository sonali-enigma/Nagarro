package com.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Author;
import com.entity.Book;
import com.service.AuthorService;
import com.service.BookService;

@Controller
public class EditController {
	@Autowired
	Book book;
	@Autowired
	AuthorService authors;
	@Autowired
	BookService bookService;

	@PostMapping("/Edit") // for post method mapping
	public ModelAndView editBook(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		
		String bookcode = request.getParameter("bookcode");
		int bookCode=Integer.parseInt(bookcode);
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		String addedon = request.getParameter("addedOn");

		book.setAddedOn(addedon);
		book.setAuthor(author);
		book.setBookCode(bookCode);
		book.setBookName(bookname);
		
		mv.addObject("book",book);
		List<Author> Author=authors.retrieveAuthors();
		
		mv.addObject("Author",Author);
		mv.setViewName("EditBook");
		
		return mv;
	}
	
	@PostMapping("/Editbook") // for post method mapping
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		String bookcode = request.getParameter("bookCode");
		int bookCode=Integer.parseInt(bookcode);
		String bookname = request.getParameter("bookName");
		String author = request.getParameter("author");
		String addedon = request.getParameter("addedOn");
      
		    
		book.setAddedOn(addedon);
		book.setAuthor(author);
		book.setBookCode(bookCode);
		book.setBookName(bookname);
		
		
		System.out.println(book);
		bookService.saveBook(book, "PUT");
		HttpSession session = request.getSession();
		List<Book> books= bookService.retrieveBooks();
		session.setAttribute("books", books);
		mv.setViewName("bookListing");
		
		return mv;
	}
}
