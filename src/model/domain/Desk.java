package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name="desk_id_seq", sequenceName="hospital_desk_seq", initialValue=1, allocationSize=1)
@Entity
public class Desk {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="desk_id_seq")
	@Column(name = "desk_id")
	private int dID;

	@OneToMany(mappedBy = "dID")
	List<Patient> patients = new ArrayList<>();

	@OneToMany(mappedBy = "dID")
	List<Clinic> clinics = new ArrayList<>();

	@OneToMany(mappedBy = "dID")
	List<Recipe> recipes = new ArrayList<>();
	
	public int getPatientsCount() {
		return patients.size();
	}

	@Override
	public String toString() {
		return "Desk [dID=" + dID + "]";
	}

}