package Exercise2;

import dao.CourseDAO;
import dao.EnrollmentDAO;
import dao.StudentDAO;
import entity.Course;
import entity.Enrollment;
import entity.Student;

import java.util.Scanner;

public class MainQuestion1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //insert Student
        StudentDAO sd = new StudentDAO();
        System.out.println("Add a new student (Last name, First name, Enrollment date (YYYY-MM-DD)): ");
        Student student = Student.builder()
                .lastName(scanner.nextLine())
                .firstName(scanner.nextLine())
                .enrollmentDate(scanner.nextLine())
                .build();
        System.out.println(sd.insert(student));

        //insert Course
        CourseDAO cd = new CourseDAO();
        System.out.println("Enter a new course (Title, Credits): ");
        Course course = Course.builder()
                .title(scanner.nextLine())
                .credits(scanner.nextDouble())
                .build();
        System.out.println(cd.insert(course));

        //insert Enrollment
        EnrollmentDAO ed = new EnrollmentDAO();
        System.out.println("Enter a new enrollment (CourseId, StudentID, Grade): ");
        Enrollment enrollment = Enrollment.builder()
                .courseId(scanner.nextInt())
                .studentId(scanner.nextInt())
                .grade(scanner.nextDouble())
                .build();
        System.out.println(ed.insert(enrollment));


    }

}
