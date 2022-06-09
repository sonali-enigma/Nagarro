package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Tshirt;
import com.service.SearchTshirt;

@Controller
public class SearchController extends Thread {

	@Autowired
	SearchTshirt searchTshirt;

	// list containing all the files with .csv extention
	static List<String> FileName;

	static File folder = new File(
			"C:\\Users\\sonaliprajapati\\eclipse-workspace\\tshirtProjectSpring\\src\\main\\resources");

	public void run() {
		FileName = new LinkedList<String>();

		for (final File fileEntry : folder.listFiles()) {

			if (fileEntry.getName().contains(".csv"))
				FileName.add(
						"C:\\Users\\sonaliprajapati\\eclipse-workspace\\tshirtProjectSpring\\src\\main\\resources\\"
								+ fileEntry.getName());

		}

		try {
			searchTshirt.insertingInDB(FileName);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostMapping("/Search")//post method mapping
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response)
			throws InterruptedException {

		ModelAndView mv = new ModelAndView();

		String colour = request.getParameter("colour");
		String size = request.getParameter("size");
		String gender = request.getParameter("gender");
		String outputPreference = request.getParameter("outputPreference");

		// thread creation
		SearchController tshirtThread = new SearchController();
		tshirtThread.start();
		tshirtThread.join();
		tshirtThread.interrupt();

		List<Tshirt> result = searchTshirt.sortTshirts(colour, size, gender, outputPreference); // calling sortTshirts
																							

		mv.addObject("result", result);
		mv.setViewName("Search");
		return mv;
	}

}
