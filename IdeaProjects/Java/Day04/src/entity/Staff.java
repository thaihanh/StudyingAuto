package entity;

import java.util.Scanner;

public class Staff extends Person {

    private double salary;

    //constructor
    public Staff() {
    }

    //constructor full tham so
    public Staff(String account, String fullName, boolean gender, String classRoom, String mobile, String email, double mark, double salary) {
        super(account, fullName, gender, classRoom, mobile, email, mark);
        this.salary = salary;
    }

    //Getter and Setter
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void display(){
        super.display();
        System.out.println(" - " + this.salary);
    }

    @Override
    public void input(){
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Enter a mark: ");
        this.salary = Double.parseDouble(scanner.nextLine());
        System.out.println();

    }
}
