package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.Disease;
import model.entity.Patient;
import model.entity.Recipe;
import util.PublicCommon;

public class CreateDAO {

	public static void rDataInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r1 = new Recipe();
			r1.setRName("독감");
			r1.setPay("68,000원");
			r1.setRx("해열제");

			Recipe r2 = new Recipe();
			r2.setRName("변비");
			r2.setPay("20,000원");
			r2.setRx("유산균");

			Recipe r3 = new Recipe();
			r3.setRName("배탈");
			r3.setPay("32,000원");
			r3.setRx("소화제");

			Recipe r4 = new Recipe();
			r4.setRName("골절");
			r4.setPay("192,000원");
			r4.setRx("깁스");

			em.persist(r1);
			em.persist(r2);
			em.persist(r3);
			em.persist(r4);

			tx.commit();

			System.out.println("■ ■ ■ 처방 데이터 저장 성공 ■ ■ ■");
			em.createNamedQuery("recipe.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	public static void pDataInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r1 = em.find(Recipe.class, 1L);
			Recipe r2 = em.find(Recipe.class, 2L);
			Recipe r3 = em.find(Recipe.class, 3L);
			Recipe r4 = em.find(Recipe.class, 4L);

			Patient p1 = new Patient();
			p1.setPName("이건우");
			p1.setGender("M");
			p1.setAge("5Y");
			p1.setBirth("17.06.12");
			p1.setPhone("010-111-1111");
			p1.setRNo(r1);

			Patient p2 = new Patient();
			p2.setPName("마슈슈");
			p2.setGender("F");
			p2.setAge("17Y");
			p2.setBirth("05.06.26");
			p2.setPhone("010-222-2222");
			p2.setRNo(r2);

			Patient p3 = new Patient();
			p3.setPName("김만두");
			p3.setGender("M");
			p3.setAge("8Y");
			p3.setBirth("13.08.08");
			p3.setPhone("010-333-3333");
			p3.setRNo(r3);

			Patient p4 = new Patient();
			p4.setPName("이제시");
			p4.setGender("F");
			p4.setAge("6Y");
			p4.setBirth("15.09.25");
			p4.setPhone("010-444-4444");
			p4.setRNo(r4);

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);

			tx.commit();

			System.out.println("■ ■ ■ 환자 데이터 저장 성공 ■ ■ ■");
			em.createNamedQuery("patient.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	public static void dDataInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r1 = em.find(Recipe.class, 1L);
			Recipe r2 = em.find(Recipe.class, 2L);
			Recipe r3 = em.find(Recipe.class, 3L);
			Recipe r4 = em.find(Recipe.class, 4L);

			Disease d1 = new Disease();
			d1.setSign("독감");
			d1.setGeneral("o");
			d1.setTest("x");
			d1.setSurgery("x");
			d1.setRNo(r1);

			Disease d2 = new Disease();
			d2.setSign("변비");
			d2.setGeneral("o");
			d2.setTest("x");
			d2.setSurgery("x");
			d2.setRNo(r2);

			Disease d3 = new Disease();
			d3.setSign("배탈");
			d3.setGeneral("o");
			d3.setTest("o");
			d3.setSurgery("x");
			d3.setRNo(r3);

			Disease d4 = new Disease();
			d4.setSign("골절");
			d4.setGeneral("o");
			d4.setTest("x");
			d4.setSurgery("x");
			d4.setRNo(r4);

			em.persist(d1);
			em.persist(d2);
			em.persist(d3);
			em.persist(d4);

			tx.commit();

			System.out.println("■ ■ ■ 질병 데이터 저장 성공 ■ ■ ■");
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
	public void createAll() {
		CreateDAO.rDataInit();
		CreateDAO.pDataInit();
		CreateDAO.dDataInit();
	}

}
