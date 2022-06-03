package Exercise2;

import dao.EnrollmentDAO;
import entity.Enrollment;

import java.util.Scanner;

public class MainQuestion3 {
    public static void main(String[] args) {
        //insert Enrollment

        EnrollmentDAO ed = new EnrollmentDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a new enrollment (CourseId, StudentID, Grade): ");
        Enrollment enrollment = Enrollment.builder()
                .courseId(scanner.nextInt())
                .studentId(scanner.nextInt())
                .grade(scanner.nextDouble())
                .build();
        System.out.println(ed.insert(enrollment));
    }
}
