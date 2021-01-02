package com.rrivas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rrivas.model.Person;

@Controller
@RequestMapping("/site")
public class HiWorldController {
	
	public final String SALUDO_HTML = "saludo";
	public final String HI_WORLD = "hiworlds";
	//forma 1
	@GetMapping("/forma")
	public String hiWorld(Model model) {
		model.addAttribute("person", new Person("ric", 23));
		return HI_WORLD;
	}

	//forma 2
	@GetMapping("/MAV")
	public ModelAndView exampleMAV() {
		
		ModelAndView mav = new ModelAndView(HI_WORLD);
		mav.addObject("person", new Person("cir", 32));
		return mav;
	}
	
	@GetMapping("/suerte")
	public String saludo() {
		return SALUDO_HTML;
	}
	
}
