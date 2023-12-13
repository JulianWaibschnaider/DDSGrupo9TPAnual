package main.java.com.Clases.BD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HibernateManager {

	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("base-diseno");
	}

	public static EntityManager getEntityManager() {
		EntityManager em = factory.createEntityManager();
		return em;
	}

	public static void comenzarTransaccion(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
		if (!tx.isActive()) {
			tx.begin();
		}
	}

	public static void commit(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
		if (tx.isActive()) {
			tx.commit();
		}
	}

	public static void rollback(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
		if (tx.isActive()) {
			tx.rollback();
		}
	}

}
