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
public class Clinic {
	
	@Id
	@Column(name="clinic_id")
	private String cID;
	
	private String sign;
	
	private String general;
	
	private String test;
	
	private String surgery;

}
