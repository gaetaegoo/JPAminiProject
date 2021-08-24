package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Desk {

	@Id
	@Column(name = "desk_id")
	private int dID;

	private String dName;
	
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