package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SequenceGenerator(name="desk_id_seq", sequenceName="hospital_desk_seq", initialValue=1, allocationSize=1)
@Entity
public class Desk {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="desk_id_seq")
	@Column(name="desk_id")
	private int dID;
	
	@Column(name="patient")
	private int pID;
	
	@Column(name="clinic")
	private int cID;
	
	@Column(name="recipe")
	private int rID;
}
