package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

	@Column(name = "patient")
	private Patient pID;

	private String pay;

	private String rx;

}