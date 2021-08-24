package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

@Entity
public class Patient {
	
	@Id
	@Column(name="patient_id")
	private String pID;
	
	private String Name;
	
	private String Gender;
	
	private String Age;
	
	private String Birth;
	
	private String phone;

}
