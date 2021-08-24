package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
public class Patient {

	@Id
	@Column(name = "patient_id")
	private String pID;

	private String name;

	private String gender;

	private String age;

	private String birth;

	private String phone;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id")
	List<Recipe> recipes = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "desk_id")
	private Desk dID;

	@Override
	public String toString() {
		return "Patient [pID=" + pID + ", name=" + name + ", gender=" + gender + ", age=" + age + ", birth=" + birth
				+ ", phone=" + phone + ", recipes=" + recipes + ", dID=" + dID + "]";
	}

}
