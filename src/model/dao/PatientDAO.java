package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.Patient;
import model.entity.Recipe;
import util.PublicCommon;

public class PatientDAO {

	// 1. 환자 생성
	public static void pInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r5 = em.find(Recipe.class, 5L);
			Recipe r6 = em.find(Recipe.class, 6L);
			Recipe r7 = em.find(Recipe.class, 7L);

			Patient p5 = new Patient();
			p5.setPName("임쿠키");
			p5.setGender("F");
			p5.setAge("5Y");
			p5.setBirth("16.03.19");
			p5.setPhone("010-555-5555");
			p5.setRNo(r5);

			Patient p6 = new Patient();
			p6.setPName("정치즈");
			p6.setGender("M");
			p6.setAge("5Y");
			p6.setBirth("16.08.24");
			p6.setPhone("010-666-6666");
			p6.setRNo(r6);

			Patient p7 = new Patient();
			p7.setPName("조하운");
			p7.setGender("M");
			p7.setAge("27Y");
			p7.setBirth("95.04.10");
			p7.setPhone("010-777-7777");
			p7.setRNo(r7);

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

	// 2. 전체 환자 조회
	public static void pSelectAll() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			System.out.println("■ ■ ■ 모든 환자 조회 성공 ■ ■ ■");
			em.createNamedQuery("patient.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 3. 특정 환자 조회
	public static void pSelectOne() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient r = (Patient) em.createNamedQuery("patient.findByname")
								    .setParameter("pName", "마슈슈")
								    .getSingleResult();
			System.out.println(r);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 4. 환자 연락처 수정
	public static void pChange() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient r = (Patient) em.createNamedQuery("patient.findByname")
								    .setParameter("pName", "마슈슈")
								    .getSingleResult();
			r.setPhone("010-020-0202");

			tx.commit();

			System.out.println("■ ■ ■ 수정 성공 ■ ■ ■");
			System.out.println(r);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 5. 환자 삭제
	public static void pDelete() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient r = (Patient) em.createNamedQuery("patient.findByname")
								    .setParameter("pName", "마슈슈")
								    .getSingleResult();
			em.remove(r);

			tx.commit();

			System.out.println("■ ■ ■ 삭제 성공 ■ ■ ■");
			em.createNamedQuery("patient.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	@Test
	public void PatientAll() {
		PatientDAO.pInit();
		PatientDAO.pSelectAll();
		PatientDAO.pSelectOne();
		PatientDAO.pChange();
		PatientDAO.pDelete();
	}

}