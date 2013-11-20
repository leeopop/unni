package org.sparcs.unni.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Index;

@Entity
public class Answer {

	@Id
	@GeneratedValue
	private long uuid;

	@ManyToOne
	@JoinColumn(name = "question")
	private Question question;

	@Lob
	@Column
	private String content;

	@Column
	@Index(name = "index_answer_time")
	private Date time = new Date();

}
