package org.sparcs.unni.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AssociationOverrides({ @AssociationOverride(name = "tagsPK.question", joinColumns = @JoinColumn(name = "question")), })
public class Tag {

	@EmbeddedId
	private TagsPK tagsPK;

	public Question getQuestion() {
		return tagsPK.getQuestion();
	}
}

@Embeddable
class TagsPK implements Serializable {

	private static final long serialVersionUID = 3207292630957460900L;

	@Column(length = 255)
	private String name;

	@ManyToOne
	private Question question;

	public Question getQuestion() {
		return question;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TagsPK that = (TagsPK) o;

		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (question != null ? !question.equals(that.question)
				: that.question != null)
			return false;
		return true;
	}

	public int hashCode() {
		int result;
		result = (question != null ? question.hashCode() : 0);
		result = 31 * result + (question != null ? question.hashCode() : 0);
		return result;
	}
}
