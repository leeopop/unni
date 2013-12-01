package org.sparcs.unni.controller;

import java.security.Principal;

import org.sparcs.unni.UnniInfo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/ask")
	public ModelAndView askPage() throws Exception {
		ModelAndView mav = new ModelAndView("ask");

		return mav;
	}
	
	@RequestMapping("/answer")  //TODO 로그인 안한 사용자 거르기, 혹은 실제 답변 작성 시에 거르기
	public ModelAndView answerPage(
			@RequestParam(required = true, value = "orig_id") String orig_id
			) throws Exception {
		ModelAndView mav = new ModelAndView("answer");
		mav.addObject("orig_id", orig_id);
		mav.addObject("title", "언니들 도와주세요~"); //TODO
		mav.addObject("oldContent","갑자기 배가 너무 아파요... 어떻게 하면 좋나요?\n좋은 방법들좀 알려주세요..."); //TODO
		return mav;
	}
	
	@RequestMapping("/questions")
	public ModelAndView questionPage() throws Exception {
		ModelAndView mav = new ModelAndView("questions"); //TODO fill data
		return mav;
	}
	
	@RequestMapping("/answers")
	public ModelAndView questionPage( //TODO only writer can list answers
			@RequestParam(required = true, value = "orig_id") String orig_id
			) throws Exception {
		ModelAndView mav = new ModelAndView("answer_list"); //TODO fill data
		return mav;
	}
}
