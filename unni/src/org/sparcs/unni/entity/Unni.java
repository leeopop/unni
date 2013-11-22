package org.sparcs.unni.entity;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.*;

import java.nio.charset.Charset;
import java.security.SecureRandom;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }),
		@UniqueConstraint(columnNames = { "nick_name" }) })
public class Unni {

	@Id
	@GeneratedValue
	@Column
	private long uuid;

	@Column(length = 255)
	private String id;

	@Column(name = "real_name", length = 255)
	private String realName;

	@Column(name = "nick_name", length = 255)
	private String nickName;

	@Column(name = "password_salt", length = 255)
	private String passwordSalt;

	@Column(name = "password_hash", length = 255)
	private String passwordHash;

	@Column
	private Date time = new Date();

	public long getUuid() {
		return uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPassword(String rawPassword) {
		
		Charset UTF8 = Charset.forName("UTF-8");
		byte[] saltByte = new byte[64];
		
		Random random = new SecureRandom();
		random.nextBytes(saltByte);
		
		
		byte[] passwordByte = rawPassword.getBytes(UTF8);
		
		String salt = Base64.encodeBase64String(saltByte);
		
		byte[] totalByte = new byte[saltByte.length + passwordByte.length];
		for(int k=0; k<saltByte.length; k++)
			totalByte[k] = saltByte[k];
		for(int k=0; k<passwordByte.length; k++)
			totalByte[k+saltByte.length] = passwordByte[k];
		
		byte[] totalHash = DigestUtils.sha512(totalByte);
		
		this.passwordSalt = salt;
		this.passwordHash = Base64.encodeBase64String(totalHash);
	}

	public Date getTime() {
		return time;
	}
}
