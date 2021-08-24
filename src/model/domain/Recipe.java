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
public class Recipe {

	@Id
	@Column(name = "recipe_id")
	private String rID;

	@ManyToMany(mappedBy = "recipes")
	List<Patient> patients = new ArrayList<>();

	private String pay;

	private String rx;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "desk_id")
	private Desk dID;

	@Override
	public String toString() {
		return "Recipe [rID=" + rID + ", pay=" + pay + ", rx=" 
	+ rx + ", dID=" + dID + "]";
	}

}