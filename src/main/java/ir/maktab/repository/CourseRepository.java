package ir.maktab.repository;

import ir.maktab.data.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CourseRepository {
    public void persist(Course course) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
