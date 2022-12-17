package ir.maktab.repository;

import ir.maktab.data.Student;
import ir.maktab.data.StudentCourseRating;

import javax.persistence.EntityManager;

public class StudentCourseRatingRepository {
    public void persist(StudentCourseRating studentCourseRating) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(studentCourseRating);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
