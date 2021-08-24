package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Patient;
import util.PublicCommon;

public class PatientDAO {

	// 1. 환자 등록
//	@Test
	void pInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Patient p1 = new Patient();
			p1.setPID("04d");
			p1.setName("이제시");
			p1.setGender("F");
			p1.setAge("6Y");
			p1.setBirth("15.09.25");
			p1.setPhone("010-444-4444");

			Patient p2 = new Patient();
			p2.setPID("05d");
			p2.setName("임쿠키");
			p2.setGender("F");
			p2.setAge("5Y");
			p2.setBirth("16.03.19");
			p2.setPhone("010-555-5555");

			Patient p3 = new Patient();
			p3.setPID("06d");
			p3.setName("정치즈");
			p3.setGender("M");
			p3.setAge("5Y");
			p3.setBirth("16.08.24");
			p3.setPhone("010-666-6666");

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);

			tx.commit();

			System.out.println("■ ■ ■ 저장 성공 ■ ■ ■");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}

	}

	// 2. 환자 수정
//	@Test
	void pChange() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient p = em.find(Patient.class, "04d");
			p.setPhone("010-987-4567");
			System.out.println(p);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 3. 환자 삭제

	// 4. 전체 환자 조회
//	@Test
	void pSelectAll() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			String jpql = "select p from Patient p";

			List<Patient> all = em.createQuery(jpql).getResultList();
			System.out.println(all);

			all.forEach(v -> System.out.println(v));

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 5. 특정 환자 조회
	@Test
	void pSelect() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient p = em.find(Patient.class, "04d");

			System.out.println("■ 이름 : " + p.getName());
			System.out.println("■ 성별 : " + p.getGender());
			System.out.println("■ 나이 : " + p.getAge());
			System.out.println("■ 생일 : " + p.getBirth());
			System.out.println("■ 연락처 : " + p.getPhone());

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

}
