package ir.maktab.service.serviceImpl;

import ir.maktab.data.Student;
import ir.maktab.repository.StudentRepository;
import ir.maktab.service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository = new StudentRepository();

    @Override
    public void save(Student student) {
        studentRepository.persist(student);
    }
}
