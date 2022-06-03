package exercise3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Filled ?: ");
        Boolean filled = scanner.nextBoolean();
        System.out.println("----------------------------------------------");

        System.out.print("Enter radius of the circle: ");
        Shape circle = new Circle(color, filled, scanner.nextDouble());
        System.out.println(circle.toString());
        System.out.println("Circle area = " + circle.getArea());
        System.out.println("Circle perimeter = " + circle.getPerimeter());
        System.out.println("----------------------------------------------");

        System.out.print("Enter width of rectangle: ");
        double width = scanner.nextDouble();
        System.out.print("Enter length of rectangle: ");
        double length = scanner.nextDouble();
        Shape rectangle = new Rectangle(color, filled, width, length);
        System.out.println(rectangle.toString());
        System.out.println("Rectangle area = " + rectangle.getArea());
        System.out.println("Rectangle perimeter = " + rectangle.getPerimeter());
        System.out.println("----------------------------------------------");

        System.out.print("Enter side of square: ");
        double side = scanner.nextDouble();
        Shape square = new Square( color, filled, side);
        System.out.println(square.toString());
        System.out.println("Square area = " + square.getArea());
        System.out.println("Square perimeter = " + square.getPerimeter());
        System.out.println("----------------------------------------------");

    }
}
