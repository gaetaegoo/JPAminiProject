package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.Recipe;
import util.PublicCommon;

public class RecipeDAO {

	// 1. 처방 생성
	public static void rInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r5 = new Recipe();
			r5.setRName("탈수");
			r5.setPay("87,600원");
			r5.setRx("수액");

			Recipe r6 = new Recipe();
			r6.setRName("발치");
			r6.setPay("432,000원");
			r6.setRx("항생제");

			Recipe r7 = new Recipe();
			r7.setRName("화상");
			r7.setPay("320,000원");
			r7.setRx("깁스");

			em.persist(r5);
			em.persist(r6);
			em.persist(r7);

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

	// 2. 전체 처방 조회
	public static void rSelectAll() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			em.createNamedQuery("recipe.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 3. 특정 처방 조회
	public static void rSelectOne() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r = (Recipe) em.createNamedQuery("recipe.findByname")
								  .setParameter("rName", "독감")
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

	// 4. 처방 가격 수정
	public static void rChange() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r = (Recipe) em.createNamedQuery("recipe.findByname")
								  .setParameter("rName", "독감")
								  .getSingleResult();
			r.setPay("6,800원");

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

	@Test
	public void RecipeAll() {
		RecipeDAO.rInit();
		RecipeDAO.rSelectAll();
		RecipeDAO.rSelectOne();
		RecipeDAO.rChange();
	}

}
