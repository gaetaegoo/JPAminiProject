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
			p1.setName("이건우");
			p1.setGender("M");
			p1.setAge("5Y");
			p1.setBirth("17.06.12");
			p1.setPhone("010-111-1111");

			Patient p2 = new Patient();
			p2.setName("마슈슈");
			p2.setGender("F");
			p2.setAge("17Y");
			p2.setBirth("05.06.26");
			p2.setPhone("010-222-2222");

			Patient p3 = new Patient();
			p3.setName("김만두");
			p3.setGender("M");
			p3.setAge("8Y");
			p3.setBirth("13.08.08");
			p3.setPhone("010-333-3333");

			Patient p4 = new Patient();
			p4.setName("이제시");
			p4.setGender("F");
			p4.setAge("6Y");
			p4.setBirth("15.09.25");
			p4.setPhone("010-444-4444");

			Patient p5 = new Patient();
			p5.setName("임쿠키");
			p5.setGender("F");
			p5.setAge("5Y");
			p5.setBirth("16.03.19");
			p5.setPhone("010-555-5555");

			Patient p6 = new Patient();
			p6.setName("정치즈");
			p6.setGender("M");
			p6.setAge("5Y");
			p6.setBirth("16.08.24");
			p6.setPhone("010-666-6666");

			Patient p7 = new Patient();
			p7.setName("조하운");
			p7.setGender("M");
			p7.setAge("27Y");
			p7.setBirth("95.04.10");
			p7.setPhone("010-777-7777");

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);
			em.persist(p5);
			em.persist(p6);
			em.persist(p7);

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
			em.find(Patient.class, 1).setPhone("010-777-7777");

			tx.commit();

			System.out.println(em.find(Patient.class, 1));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 3. 환자 삭제
//	@Test
	void pDelete() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			em.remove(em.find(Patient.class, 1));

			tx.commit();

			System.out.println(em.find(Patient.class, 1));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}

	}

	// 4. 전체 환자 검색
	@Test
	void pSelectAll() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			String jpql = "select p from Patient p ";

			List<Patient> all = em.createQuery(jpql).getResultList();

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

	// 5. 특정 환자 검색
//	@Test
	void pSelect() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient p = em.find(Patient.class, 1);

			System.out.println("■ 이름: " + p.getName());
			System.out.println("■ 성별: " + p.getGender());
			System.out.println("■ 나이: " + p.getAge());
			System.out.println("■ 생일: " + p.getBirth());
			System.out.println("■ 연락처: " + p.getPhone());

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
