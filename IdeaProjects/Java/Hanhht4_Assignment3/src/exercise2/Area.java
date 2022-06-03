package exercise2;

import java.awt.*;
import java.util.Scanner;

public class Area {

    public static void main(String[] args) {
        Area rectangle = new Area();
        rectangle.input();
        rectangle.returnArea();

    }
    private double length;
    private double breadth;

    //constructor no params
    public Area(){
    }

    //constructor full params
    public Area(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    //Getter and Setter

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    //Enter parameters
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length = ");
        this.length = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter breadth = ");
        this.breadth = Double.parseDouble(scanner.nextLine());
    }

    public void returnArea(){
        double a = this.length * this.breadth;
        System.out.print("Area = " + a);
    }
}
