package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PublicCommon {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDB");
	
	public static EntityManager getEntityManager() {
		// EntityManagerFactory 객체로부터 EntityManager 객체 반환
		return emf.createEntityManager();
	}
	
	// 24시간 365일 서버가 실행중인 서비스의 코드
	// 이 close 메소드는 서버 다운 직전 또는 더이상 JPA의 EntityManager 객체 생성할 필요가 없을 때 메모리 자원 해제용으로 호출
	public static void close() {
		// EntityManagerFactory 자원반환
		emf.close();
		emf = null;
	}

}
