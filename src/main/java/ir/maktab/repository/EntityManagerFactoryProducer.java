package ir.maktab.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
}
