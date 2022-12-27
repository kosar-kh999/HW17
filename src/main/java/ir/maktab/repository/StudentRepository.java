package ir.maktab.repository;

import ir.maktab.data.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StudentRepository {
    public void persist(Student student) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
