package com.rrivascode.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoursesController {
	
	@RequestMapping("courses")
//	@ResponseBody
	public String courses(HttpServletRequest req) {
//		System.out.println("Welcome to rriverDev");
		
		HttpSession session = req.getSession();
		String cname = req.getParameter("MyOutPar");
		System.out.println("The name of course is: " + cname);
		session.setAttribute("MyOutPar", cname);
		return "course";
	}

}
