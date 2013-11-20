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

}