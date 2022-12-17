package ir.maktab.data;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@IdClass(StudentCourseRatingId.class)
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseRating {
    @Id
    @ManyToOne
    private Student student;
    @Id
    @ManyToOne
    private Course course;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timeStamp;
    private double rating;
    private String comment;
}
