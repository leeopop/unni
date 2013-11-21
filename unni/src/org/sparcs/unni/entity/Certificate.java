package org.sparcs.unni.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Index;

@Entity
public class Certificate {

	public enum CERT_TYPE {
		CT1, CT2,
	};

	@Id
	@GeneratedValue
	private long uuid;

	@ManyToOne
	@JoinColumn(name = "user")
	private Unni user;

	@Column(length = 255)
	@Enumerated(EnumType.STRING)
	private CERT_TYPE type;

	@Lob
	@Column(name = "certificate_info")
	private String certificateInfo;

	@Column
	@Index(name = "index_certificate")
	private Date time = new Date();

	public long getUuid() {
		return uuid;
	}

	public Unni getUser() {
		return user;
	}

	public void setUser(Unni user) {
		this.user = user;
	}

	public CERT_TYPE getType() {
		return type;
	}

	public void setType(CERT_TYPE type) {
		this.type = type;
	}

	public String getCertificateInfo() {
		return certificateInfo;
	}

	public void setCertificateInfo(String certificateInfo) {
		this.certificateInfo = certificateInfo;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}