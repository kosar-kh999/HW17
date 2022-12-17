package ir.maktab.service.serviceImpl;

import ir.maktab.data.Course;
import ir.maktab.repository.CourseRepository;
import ir.maktab.service.CourseService;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository = new CourseRepository();

    @Override
    public void save(Course course) {
        courseRepository.persist(course);
    }
}
