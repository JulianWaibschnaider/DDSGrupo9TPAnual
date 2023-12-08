package  com.Clases.BD;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory sessionFactory = buildSessionFactory();

    private static EntityManagerFactory buildSessionFactory() {
        try {
            // Crea la sesión de Hibernate desde el archivo de configuración
            return Persistence.createEntityManagerFactory("basediseno");
        } catch (Throwable ex) {
            System.err.println("Error al crear la sesión de Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getSessionFactory() {
        return sessionFactory;
    }



}
