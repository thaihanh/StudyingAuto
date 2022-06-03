package entity;

import lombok.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@Builder

public class Enrollment {

    private int id;
    private int courseId;
    private int studentId;
    private double grade;
}
