package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.Disease;
import model.entity.Recipe;
import util.PublicCommon;

public class DiseaseDAO {

	// 1. 질병 생성
	public static void dInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r5 = em.find(Recipe.class, 5L);
			Recipe r6 = em.find(Recipe.class, 6L);
			Recipe r7 = em.find(Recipe.class, 7L);

			Disease d5 = new Disease();
			d5.setSign("탈수");
			d5.setGeneral("o");
			d5.setTest("x");
			d5.setSurgery("x");
			d5.setRNo(r5);

			Disease d6 = new Disease();
			d6.setSign("발치");
			d6.setGeneral("o");
			d6.setTest("o");
			d6.setSurgery("x");
			d6.setRNo(r6);

			Disease d7 = new Disease();
			d7.setSign("화상");
			d7.setGeneral("o");
			d7.setTest("o");
			d7.setSurgery("x");
			d6.setRNo(r7);

			em.persist(d5);
			em.persist(d6);
			em.persist(d7);

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

	// 2. 전체 질병 조회
	public static void dSelectAll() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			em.createNamedQuery("disease.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 3. 특정 질병 조회
	public static void dSelectOne() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Disease r = (Disease) em.createNamedQuery("disease.findBysign")
									.setParameter("sign", "독감")
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

	// 4. 질병 검사 여부 수정
	public static void dChange() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Disease r = (Disease) em.createNamedQuery("disease.findBysign")
								    .setParameter("sign", "정기검진")
								    .getSingleResult();
			r.setTest("o");

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

	// 5. 질병 삭제
	public static void dDelete() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Disease r = (Disease) em.createNamedQuery("disease.findBysign").setParameter("sign", "변비")
					.getSingleResult();
			em.remove(r);

			tx.commit();

			System.out.println("■ ■ ■ 삭제 성공 ■ ■ ■");
			em.createNamedQuery("disease.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	@Test
	public void DiseaseAll() {
		DiseaseDAO.dInit();
		DiseaseDAO.dSelectAll();
		DiseaseDAO.dSelectOne();
		DiseaseDAO.dChange();
		DiseaseDAO.dDelete();
	}

}
