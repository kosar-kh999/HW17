package ir.maktab.repository;

import ir.maktab.data.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StudentRepository {
    public void persist(Student student) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Student findByName(String studentName) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Student s where s.studentName =:studentName");
        query.setParameter("studentName", studentName);
        Student student = (Student) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return student;
    }
}
