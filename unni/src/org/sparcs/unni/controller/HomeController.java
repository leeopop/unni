package org.sparcs.unni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView frontPage() throws Exception {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", "WOW");
		mav.setViewName("front");
		return mav;
	}

}
