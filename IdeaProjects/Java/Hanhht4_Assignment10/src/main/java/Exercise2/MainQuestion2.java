package Exercise2;

import dao.StudentDAO;
import entity.Student;

import java.util.Scanner;

public class MainQuestion2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //update enrollment for student
        StudentDAO sd = new StudentDAO();
        System.out.println("Update Enrollment date (YYYY-MM-DD)) for student ID: ");
        Student student = Student.builder()
                .enrollmentDate(scanner.nextLine())
                .id(scanner.nextInt())
                .build();
        System.out.println(sd.updateEnrollmentDate(student));
    }
}
