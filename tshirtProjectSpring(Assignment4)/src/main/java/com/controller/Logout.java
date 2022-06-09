package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logout {

	@PostMapping("/Logout")
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		mv.setViewName("login");

		return mv;
	}

}
