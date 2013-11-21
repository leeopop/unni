package org.sparcs.unni.controller;

import org.sparcs.unni.entity.Unni;
import org.sparcs.unni.service.UnniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UnniController {

	@Autowired
	private UnniService unniService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String createNewUnni(@RequestParam(required = true, value = "id") String id,
			@RequestParam(required = false, value = "realname") String realName,
			@RequestParam(required = true, value = "nickname") String nickName,
			@RequestParam(required = true, value = "password") String newPassword,
			@RequestParam(required = true, value = "password_re") String checkPassword)
			throws Exception {

		// TODO
		// check if id is already existed
		// check if nick name is already existed

		if ("".equals(newPassword) || !!!newPassword.equals(checkPassword)) {
			throw new Exception("Invalid password");
		}

		Unni unni = unniService.createUnni(id, realName, nickName, newPassword);
		return "creating " + unni.getNickName() + " completed!";
	}
}
