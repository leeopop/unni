package org.sparcs.unni.controller;

import java.security.Principal;

import org.sparcs.unni.UnniInfo;
import org.springframework.security.core.Authentication;
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

	@RequestMapping("/login")
	public ModelAndView loginPage() throws Exception {
		return new ModelAndView("login");
	}

	@RequestMapping("/user")
	public ModelAndView userInfoPage(Principal principal) throws Exception {

		UnniInfo unniInfo = (UnniInfo) ((Authentication) principal).getPrincipal();
		System.out.println("Unni " + unniInfo.getNickName() + " is here.");

		ModelAndView mdv = new ModelAndView("user");
		mdv.addObject("nickname", unniInfo.getNickName());
		return mdv;
	}

}
