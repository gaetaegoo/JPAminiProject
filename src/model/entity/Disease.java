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
@SequenceGenerator(name = "disease_no_seq", sequenceName = "hospital_disease_seq", initialValue = 1, allocationSize = 1)
@NamedQuery(query = "select d from disease d", name = "disease.findAll")
@NamedQuery(query = "select d from disease d where d.sign=:sign", name = "disease.findBysign")
@Entity(name = "disease")
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disease_no_seq")
	@Column(name = "disease_no")
	private long dNo;

	private String sign;

	private String general;

	private String test;

	private String surgery;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_no")
	private Recipe rNo;

	@Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append(" 1) 질병 번호 : ");
       builder.append(dNo);
       builder.append("\n 2) 증상 : ");
       builder.append(sign);
       builder.append("\n 3) 일반 검사 여부 : ");
       builder.append(general);
       builder.append("\n 4) 정밀 검사 여부 : ");
       builder.append(test);
       builder.append("\n 5) 수술 여부 : ");
       builder.append(surgery);
       builder.append("\n 6) 처방 정보 : ");
       builder.append(rNo + "\n");
       return builder.toString();
    }
	
}
