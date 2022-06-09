package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.LoginDao;

@Controller
public class LoginController {

	@Autowired
	LoginDao loginDao;

	@PostMapping("/login")//for post method mapping
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		//getting username and password
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		//function to check user exist or not
		if (loginDao.checkLogin(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			mv.setViewName("welcome");
		} else {
			mv.setViewName("login");
		}
		return mv;
	}

}
