package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.domain.Patient;
import util.PublicCommon;

public class PatientDAO {
	
	// 특정 환자 검색
//	@Test
	void pSelect() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			Patient p = em.find(Patient.class, "01a");
			
			System.out.println("■ 이름: " + p.getName());
			System.out.println("■ 성별: " + p.getGender());
			System.out.println("■ 나이: " + p.getAge());
			System.out.println("■ 생일: " + p.getBirth());
			System.out.println("■ 연락처: " + p.getPhone());
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
			em = null;
		}
	}
		
	
	// 환자 등록
//	@Test
	void pInit() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			Patient patient = new Patient();
			patient.setPatientName("남부고");
			
			Patient s1 = new Patient();
			s1.setName("재석");
			s1.setpID(11);
			s1.setpID(patient);
			
			Patient s2 = new Patient();
			s2.setName("종원");
			s2.setStuNo(22);
			s2.setPatientId(patient);
			
			patient.getPatients().add(s1);
			patient.getPatients().add(s2);
			
			em.persist(patient);
			em.persist(s1);
			em.persist(s2);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
			em = null;
		}
	}

}
