package entity;

import lombok.*;
import java.util.Date;
import java.util.Scanner;

@Getter
@Setter
@ToString
@Builder

public class Student {

    private int id;
    private String lastName;
    private String firstName;
    private String enrollmentDate;


//    public void input() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter a new student: ");
//        System.out.println("Last name:");
//        lastName = scan.nextLine();
//        System.out.println("First name:");
//        firstName = scan.nextLine();
//        System.out.println("Enrollment date (YYYY-MM-DD):");
//        enrollmentDate = scan.nextLine();
//    }

}
