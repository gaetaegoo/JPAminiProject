package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Desk;
import model.domain.Patient;
import util.PublicCommon;

public class DeskDAO {

	@Test
	void init() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Desk desk = new Desk();
			desk.setDName("피부과");
			
			Patient p99 = new Patient();
			p99.setName("박모모");
			p99.setGender("F");
			p99.setAge("3Y");
			p99.setBirth("19.08.12");
			p99.setPhone("010-888-8888");
			
			em.persist(desk);
			em.persist(p99);
			
			tx.commit();
			
			System.out.println(p99.getDID());
			System.out.println(p99.getDID().getDName());
			
			String jpql = "select p from Patient p ";

			List<Patient> all = em.createQuery(jpql).getResultList();

			all.forEach(v -> System.out.println(v));
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

}