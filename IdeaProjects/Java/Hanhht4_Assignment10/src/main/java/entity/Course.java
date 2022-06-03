package entity;

import lombok.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@Builder

public class Course {

    private int id;
    private String title;
    private double credits;
}
