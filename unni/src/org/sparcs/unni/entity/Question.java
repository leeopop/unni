package org.sparcs.unni.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private long uuid;

	@Column(length = 255)
	private String title;

	@Lob
	@Column
	private String content;

	@ManyToOne
	@JoinColumn(name = "writer")
	private Unni writer;

	@Column
	@Index(name = "index_question_time")
	private Date time = new Date();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tagsPK.question", orphanRemoval = true)
	@Cascade({ CascadeType.ALL })
	private Set<Tag> tags;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", orphanRemoval = true)
	@Cascade({ CascadeType.ALL })
	private Set<Answer> answers;

}
