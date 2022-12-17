package ir.maktab.data;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentCourseRatingId implements Serializable {
    private Course course;
    private Student student;
}
