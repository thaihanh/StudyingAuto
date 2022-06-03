package entity;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.Scanner;

public class Student extends Person implements IStudy {
    @Override
    public void method() {

    }

    @Override
    public void learning() {

    }

    private String classRoom;
    private double mark;

    //constructor

    //constructor khong tham so
    public Student() {
    }

    //constructor full tham so
    public Student(String account, String fullName, boolean gender, String classRoom, String mobile, String email, double mark) {

        this.classRoom = classRoom;
        this.mark = mark;
    }

    //Getter and Setter
    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public void display(){
        super.display();
        System.out.println(" - " + this.classRoom + " - " + this.mark);
        System.out.println("=====================================================================================");
    }

    @Override
    public void input(){
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Enter a classRoom: ");
        this.classRoom = scanner.nextLine();
        System.out.print("Enter a mark: ");
        this.mark = Double.parseDouble(scanner.nextLine());
        System.out.println();

    }
}
