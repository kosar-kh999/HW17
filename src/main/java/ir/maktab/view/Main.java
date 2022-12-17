package ir.maktab.view;

import ir.maktab.data.StudentCourseRating;
import ir.maktab.service.serviceImpl.StudentCourseServiceImpl;

public class Main {
    private static final StudentCourseServiceImpl studentCourseService = new StudentCourseServiceImpl();

    public static void main(String[] args) {
        StudentCourseRating load = studentCourseService.load(1);
        System.out.println(load);
    }
}
