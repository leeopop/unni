package org.sparcs.unni;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class UnniAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		String username = request.getParameter("userid");
		return username;
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		String username = request.getParameter("password");
		return username;
	}

	@Override
	public void setRememberMeServices(RememberMeServices service) {
		super.setRememberMeServices(service);
	}

}
