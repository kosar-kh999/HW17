package ir.maktab.repository;

import ir.maktab.data.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CourseRepository {
    public void persist(Course course) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Course findCourseByName(String courseName) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Course c where c.courseName=:courseName");
        query.setParameter("courseName", courseName);
        Course course = (Course) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }
}
