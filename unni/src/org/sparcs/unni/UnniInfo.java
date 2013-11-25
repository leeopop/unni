package org.sparcs.unni;

import java.util.Collection;

import org.sparcs.unni.entity.Unni;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UnniInfo extends User {

	private static final long serialVersionUID = -6202740491944547112L;

	private long uuid;
	private String nickName;
	private String realName;
	private String id;

	public UnniInfo(String username, String password,
			Collection<? extends GrantedAuthority> authorities, Unni unni) {
		super(username, password, authorities);

		this.nickName = unni.getNickName();
		this.realName = unni.getNickName();
		this.uuid = unni.getUuid();
		this.id = unni.getId();
	}

	public long getUuid() {
		return uuid;
	}

	public String getNickName() {
		return nickName;
	}

	public String getRealName() {
		return realName;
	}

	public String getId() {
		return id;
	}

}
