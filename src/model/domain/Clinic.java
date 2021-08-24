package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Clinic {

	@Id
	@Column(name = "clinic_id")
	private String cID;

	private String sign;

	private String general;

	private String test;

	private String surgery;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "desk_id")
	private Desk dID;

	@Override
	public String toString() {
		return "Clinic [cID=" + cID + ", sign=" + sign + ", general=" + general + ", test=" + test + ", surgery="
				+ surgery + "]";
	}

}