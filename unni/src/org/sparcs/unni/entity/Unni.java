package org.sparcs.unni.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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

}
