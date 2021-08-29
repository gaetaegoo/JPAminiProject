package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "patient_no_seq", sequenceName = "hospital_patient_seq", initialValue = 1, allocationSize = 1)
@NamedQuery(query = "select p from patient p", name = "patient.findAll")
@NamedQuery(query = "select p from patient p where p.pName=:pName", name = "patient.findByname")
@Entity(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_no_seq")
	@Column(name = "patient_no")
	private long pNo;

	@Column(name = "patient_name")
	private String pName;

	private String gender;

	private String age;

	private String birth;

	private String phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_no")
	private Recipe rNo;

	@Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append(" 1) 환자 번호 : ");
       builder.append(pNo);
       builder.append("\n 2) 환자 이름 : ");
       builder.append(pName);
       builder.append("\n 3) 성별 : ");
       builder.append(gender);
       builder.append("\n 4) 나이 : ");
       builder.append(age);
       builder.append("\n 5) 출생 : ");
       builder.append(birth);
       builder.append("\n 6) 연락처 : ");
       builder.append(phone);
       builder.append("\n 7) 처방 정보 : ");
       builder.append(rNo + "\n");
       return builder.toString();
    }
	
}
