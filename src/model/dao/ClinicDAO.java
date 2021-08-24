package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Clinic;
import util.PublicCommon;

public class ClinicDAO {

//  1. 질병 등록
//   @Test
   void cInit() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();
      tx.begin();

      try {
         Clinic c1 = new Clinic();
         c1.setCID("J00-J99");
         c1.setSign("감기");
         c1.setGeneral("o");
         c1.setTest("x");
         c1.setSurgery("x");

         Clinic c2 = new Clinic();
         c2.setCID("Z00");
         c2.setSign("정기검진");
         c2.setGeneral("o");
         c2.setTest("x");
         c2.setSurgery("x");

         Clinic c3 = new Clinic();
         c3.setCID("S80-S89");
         c3.setSign("찰과상");
         c3.setGeneral("o");
         c3.setTest("o");
         c3.setSurgery("x");

         Clinic c4 = new Clinic();
         c4.setCID("L20-L30");
         c4.setSign("피부병");
         c4.setGeneral("o");
         c4.setTest("x");
         c4.setSurgery("x");

         Clinic c5 = new Clinic();
         c5.setCID("S40-S49");
         c5.setSign("골절");
         c5.setGeneral("o");
         c5.setTest("o");
         c5.setSurgery("o");

         em.persist(c1);
         em.persist(c2);
         em.persist(c3);
         em.persist(c4);
         em.persist(c5);

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

//  2. 질병 수정
//   @test
   void cChange() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();

      try {
         em.find(Clinic.class, "Z00").setTest("o");

         tx.commit();

         System.out.println(em.find(Clinic.class, "Z00"));
         
      } catch (Exception e) {
         tx.rollback();
         e.printStackTrace();
      } finally {
         em.close();
         em = null;
      }

   }

//   3. 전체 질병 조회
   @Test
   void cSelectAll() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();

      try {
         String jpql = "select c from Clinic c";

         List<Clinic> all = em.createQuery(jpql).getResultList();

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

//   4. 특정 질병 조회
//   @Test
   void cSelect() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();

      try {
         Clinic c = em.find(Clinic.class, "J00-J99");

         System.out.println("■ 질병 코드 : " + c.getCID());
         System.out.println("■ 병명 : " + c.getSign());
         System.out.println("■ 진료 여부 : " + c.getGeneral());
         System.out.println("■ 검사 여부 : " + c.getTest());
         System.out.println("■ 수술 여부 : " + c.getSurgery());
         
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