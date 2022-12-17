package ir.maktab.service.serviceImpl;

import ir.maktab.data.Course;
import ir.maktab.data.Student;
import ir.maktab.data.StudentCourseRating;
import ir.maktab.repository.StudentCourseRatingRepository;
import ir.maktab.service.StudentCourseRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentCourseServiceImpl implements StudentCourseRatingService {
    private Logger logger = LoggerFactory.getLogger(StudentCourseServiceImpl.class);
    StudentCourseRatingRepository studentCourseRatingRepository = new StudentCourseRatingRepository();
    StudentServiceImpl studentService = new StudentServiceImpl();
    CourseServiceImpl courseService = new CourseServiceImpl();

    @Override
    public StudentCourseRating load(int lineNumber) {
        try (RandomAccessFile file = new RandomAccessFile("file.txt", "rw")) {
            String readLine = null;
            for (int i = 1; i <= lineNumber; i++) {
                readLine = file.readLine();
            }
            String[] studentInfo = readLine.split(",");
            StudentCourseRating studentCourseRating = new StudentCourseRating();
            Student student = new Student();
            Course course = new Course();
            studentCourseRating.getCourse().setCourseName(studentInfo[0]);
            studentCourseRating.getStudent().setStudentName(studentInfo[1]);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse(studentInfo[2]);
            studentCourseRating.setTimeStamp(date);
            studentCourseRating.setRating(Double.parseDouble(studentInfo[3]));
            studentCourseRating.setComment(studentInfo[4]);
            logger.info("student course rating load");
            studentService.save(student);
            courseService.save(course);
            studentCourseRatingRepository.persist(studentCourseRating);
            return studentCourseRating;
        } catch (FileNotFoundException e) {
            logger.error("file not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("io exception");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            logger.error("date to string exception");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student, Course course) {

    }

    @Override
    public int count() {
        return 0;
    }

}
