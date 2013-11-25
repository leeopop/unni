package org.sparcs.unni.service.impl;

import java.util.Collection;
import java.util.HashSet;

import org.sparcs.unni.UnniInfo;
import org.sparcs.unni.entity.Unni;
import org.sparcs.unni.service.UnniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UnniService unniService;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Unni unni = unniService.findUnni(id);
		System.out.println(unni);
		UserDetails user = buildUnniInfoFromUnni(unni);
		return user;
	}

	public UnniInfo buildUnniInfoFromUnni(Unni unni) {

		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		UnniInfo unniInfo = new UnniInfo(unni.getId(), unni.getPassword(), authorities, unni);
		return unniInfo;
	}
}
