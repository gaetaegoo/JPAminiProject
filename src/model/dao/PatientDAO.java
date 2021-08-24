package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import model.domain.Patient;
import util.PublicCommon;

public class PatientDAO {
	
	//하나 데이터 조회
	@Test
	void pSelect() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient p = em.find(Patient.class, "01a");
			
			System.out.println("이름 : " + p.getName());
			System.out.println("성별 : " + p.getGender());
			System.out.println("나이 : " + p.getAge());
			System.out.println("생일 : " + p.getBirth());
			System.out.println("연락처 : " + p.getPhone());
			
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	
	//데이터 저장
//	@Test
	public void pInit() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		try {
			Patient patient = new Patient();
			patient.setPhone("010-999-9998");
			
			
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
	}
}
