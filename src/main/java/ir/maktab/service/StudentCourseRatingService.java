package ir.maktab.service;

import ir.maktab.data.Course;
import ir.maktab.data.Student;
import ir.maktab.data.StudentCourseRating;

public interface StudentCourseRatingService {

    StudentCourseRating load(int lineNumber);
    void save(Student student, Course course);
    int count();
}
