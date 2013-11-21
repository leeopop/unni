package org.sparcs.unni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sparcs.unni.entity.Qualification.COND_TYPE;

@Entity
public class Qualification {

	public enum COND_TYPE {
		COND_TYPE1, COND_TYPE2,
	}

	@EmbeddedId
	private QualificationPK conditionPK;

	@Column(name = "max_int")
	private long maxInt;

	@Column(name = "min_int")
	private long minInt;

	public void setConditionPK(QualificationPK pk) {
		this.conditionPK = pk;
	}

	public COND_TYPE getType() {
		return conditionPK.getType();
	}

	public Question getQuestion() {
		return conditionPK.getQuestion();
	}

	public long getMaxInt() {
		return maxInt;
	}

	public void setMaxInt(long maxInt) {
		this.maxInt = maxInt;
	}

	public long getMinInt() {
		return minInt;
	}

	public void setMinInt(long minInt) {
		this.minInt = minInt;
	}

}

@Embeddable
class QualificationPK implements Serializable {

	private static final long serialVersionUID = 2861821994459802563L;

	@Column
	@Enumerated(EnumType.STRING)
	private COND_TYPE type;

	@ManyToOne
	@JoinColumn(name = "question")
	private Question question;

	public QualificationPK(COND_TYPE type, Question q) {
		this.type = type;
		this.question = q;
	}

	public COND_TYPE getType() {
		return type;
	}

	public void setType(COND_TYPE type) {
		this.type = type;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		QualificationPK that = (QualificationPK) o;

		if (type != null ? !type.equals(that.type) : that.type != null)
			return false;
		if (question != null ? !question.equals(that.question)
				: that.question != null)
			return false;
		return true;
	}

	public int hashCode() {
		int result;
		result = (type != null ? type.hashCode() : 0);
		result = 31 * result + (question != null ? question.hashCode() : 0);
		return result;
	}
}
