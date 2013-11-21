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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tagPK.question", orphanRemoval = true)
	@Cascade({ CascadeType.ALL })
	private Set<Tag> tags;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", orphanRemoval = true)
	@Cascade({ CascadeType.ALL })
	private Set<Answer> answers;

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Unni getWriter() {
		return writer;
	}

	public void setWriter(Unni writer) {
		this.writer = writer;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

}
