package problem2.entities;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainee {
    private int traineeId;
    private String account;
    private String fullName;
    private byte gender;
    private Date birthDate;
    private String phoneNumber;
    private String gpa;
    private String status;

}
