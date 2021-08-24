package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Desk;
import model.domain.Recipe;
import util.PublicCommon;

public class RecipeDAO {

   // 1. 처방 등록
//   @Test
   void rInit() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();
      tx.begin();

      try {
         Desk desk = new Desk();

         Recipe r1 = new Recipe();
         r1.setRID("A");
         r1.setPay("38,900원");
         r1.setRx("감기약");

         Recipe r2 = new Recipe();
         r2.setRID("B");
         r2.setPay("0원");
         r2.setRx("유산균");

         Recipe r3 = new Recipe();
         r3.setRID("C");
         r3.setPay("75,000원");
         r3.setRx("항생제, 연고");

         Recipe r4 = new Recipe();
         r4.setRID("D");
         r4.setPay("490,500원");
         r4.setRx("항생제, 연고, 주사");

         Recipe r5 = new Recipe();
         r5.setRID("E");
         r5.setPay("690,000원");
         r5.setRx("깁스, 영양제, 칼슘");

         desk.getRecipes().add(r1); // 이거 확인해야됨 !!

         em.persist(r1);
         em.persist(r2);
         em.persist(r3);
         em.persist(r4);
         em.persist(r5);

         tx.commit();

         System.out.println("■ ■ ■ 처방 완료 ■ ■ ■");
      } catch (Exception e) {
         tx.rollback();
         e.printStackTrace();
      } finally {
         em.close();
         em = null;
      }
   }

   // 2. 처방 수정
//   @Test
   void rChange() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();

      try {
         Recipe r = em.find(Recipe.class, "B");
         r.setPay("21,000");

         tx.commit();

         System.out.println(em.find(Recipe.class, "B"));

      } catch (Exception e) {
         tx.rollback();
         e.printStackTrace();
      } finally {
         em.close();
         em = null;
      }

   }

   // 3. 처방 삭제
//   @Test
   void rDelete() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();

      try {
         Recipe r = em.find(Recipe.class, "D");
         em.remove(r);

         System.out.println("처방 삭제가 완료 되었습니다.");

         tx.commit();

         System.out.println(em.find(Recipe.class, "D"));

      } catch (Exception e) {
         tx.rollback();
         e.printStackTrace();
      } finally {
         em.close();
         em = null;
      }

   }

   // 4. 전체 처방 조회
//   @Test
   void rSelectAll() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();

      try {

         String jpql = "select r from Recipe r";

         List<Recipe> all = em.createQuery(jpql).getResultList();
//         System.out.println(all);

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

   // 5. 특정 처방 조회
   @Test
   void rSelect() {
      EntityManager em = PublicCommon.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();

      try {
         Recipe r = em.find(Recipe.class, "C");

         System.out.println("■ 환자 ID : " + r.getPatients());
         System.out.println("■ 처방약 :  " + r.getRx());
         System.out.println("■ 치료비 : " + r.getPay());

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