package org.sparcs.unni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "Infos")
@org.hibernate.annotations.Table(appliesTo = "Infos", indexes = {
		@Index(name = "index_info_int", columnNames = { "type", "int_value",
				"certificate" }),
		@Index(name = "index_info_text", columnNames = { "type", "text_value",
				"certificate" }), })
public class Info {

	@EmbeddedId
	private InfosPK infosPK;

	@Column(name = "int_value")
	private long intValue;

	@Column(length = 25, name = "text_value")
	private String textValue;

	@ManyToOne
	@JoinColumn(name = "certificate")
	private Certificate certificate;

	@Column
	private Date time = new Date();

}

@Embeddable
class InfosPK implements Serializable {

	private static final long serialVersionUID = 2625600544953530217L;

	@Column(length = 255)
	private String type;

	@ManyToOne
	@JoinColumn(name = "user")
	private Unni user;

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		InfosPK that = (InfosPK) o;

		if (type != null ? !type.equals(that.type) : that.type != null)
			return false;
		if (user != null ? !user.equals(that.user) : that.user != null)
			return false;
		return true;
	}

	public int hashCode() {
		int result;
		result = (type != null ? type.hashCode() : 0);
		result = 31 * result + (user != null ? user.hashCode() : 0);
		return result;
	}
}