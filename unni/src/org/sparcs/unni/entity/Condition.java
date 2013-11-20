package org.sparcs.unni.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.sparcs.unni.entity.Condition.COND_TYPE;

@Entity
public class Condition {

	public enum COND_TYPE {
		COND_TYPE1, COND_TYPE2,
	}

	@EmbeddedId
	private ConditionsPK conditionsPK;

	@Column(name = "max_int")
	private BigInteger maxInt;

	@Column(name = "min_int")
	private BigInteger minInt;

}

@Embeddable
class ConditionsPK implements Serializable {

	private static final long serialVersionUID = 2861821994459802563L;

	@Column
	@Enumerated(EnumType.STRING)
	private COND_TYPE type;

	@ManyToOne
	private Question question;

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ConditionsPK that = (ConditionsPK) o;

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
