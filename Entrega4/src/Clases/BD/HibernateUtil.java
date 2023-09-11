package Clases.BD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final EntityManagerFactory sessionFactory = buildSessionFactory();

    private static EntityManagerFactory buildSessionFactory() {
        try {
            // Crea la sesión de Hibernate desde el archivo de configuración
            return new Configuration().configure("Clases/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al crear la sesión de Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getSessionFactory() {
        return sessionFactory;
    }
}
