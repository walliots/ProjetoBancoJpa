package model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("projetoJPA");
	}
	/**
	 * metodo responsavel por retornar um entityManager 
	 * @return EntityManager
	 */
	public static  EntityManager getEntityManager() {
		return factory.createEntityManager();
		
	}
	
	public static void closeEntityManager() {
		factory.close();
		
	}

}
