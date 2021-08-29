package model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@NamedQuery(query = "select r from recipe r", name = "recipe.findAll")
@NamedQuery(query = "select r from recipe r where r.rName=:rName", name = "recipe.findByname")
@SequenceGenerator(name = "recipe_no_seq", sequenceName = "hospital_recipe_seq", initialValue = 1, allocationSize = 1)
@Entity(name = "recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_no_seq")
	@Column(name = "recipe_no")
	private long rNo;

	@Column(name = "recipe_name")
	private String rName;

	private String pay;

	private String rx;

//	@OneToMany
//	List<Patient> patients = new ArrayList<>();
//
//	@OneToMany
//	List<Disease> diseases = new ArrayList<>();

	@Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append(" ■ 처방 번호 : ");
       builder.append(rNo);
       builder.append("\t ■ 진단명 : ");
       builder.append(rName);
       builder.append("\t ■ 진단비 : ");
       builder.append(pay);
       builder.append("\t ■ 처방약 : ");
       builder.append(rx + "\n");
       return builder.toString();
    }

}
