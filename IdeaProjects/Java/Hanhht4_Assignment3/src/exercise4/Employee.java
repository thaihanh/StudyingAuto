package exercise4;

import java.util.Scanner;

public class Employee {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.getInfo();
        employee.addSal(employee.getSalary());
        employee.addWork(employee.getSalary(), employee.getHoursPerDay());
        System.out.println("Total Salary ($) = " + employee.getSalary());
    }
    private double salary;
    private double hoursPerDay;

    //Constructor
    public Employee() {
    }

    public Employee(double salary, double hoursPerDay) {
        this.salary = salary;
        this.hoursPerDay = hoursPerDay;
    }

    //getter and setter
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(double hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    //input
    public void getInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter salary($): ");
        this.salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter number of work hours per day (hour): ");
        this.hoursPerDay = Double.parseDouble(scanner.nextLine());
    }

    //method AddSal()
    public void addSal(double salary) {
        if (this.salary < 500) {
            System.out.println("Additional salary for salary < 500$ ($) = 10");
            salary += 10;
        }
        this.salary = salary ;
    }

    public void addWork(double salary, double hoursPerDay) {
        if (this.hoursPerDay > 6) {
            System.out.println("Additional salary for work hours per day > 6 ($) = 5");
            salary += 5;
        }
        this.salary = salary ;
    }
}
