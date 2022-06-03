package exercise3;

import static java.lang.Math.PI;

public class Circle extends Shape {

    private double radius;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle[Shape[color=" + this.color + ",filled=" + this.isFilled() + "],radius=" +this.radius + "]";
    }

    @Override
    public double getArea() {
        return 2 * PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * this.radius;
    }
}
