package mine;
abstract class Shape {
    // Abstract method to calculate area
    public abstract double calculateArea();

    // Concrete method to display information
    public void displayInfo() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("This is a circle with radius: " + radius);
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("This is a rectangle with length: " + length + " and width: " + width);
    }
}

public class Main {
    public static void main(String[] args) {
        // Method Overloading
        System.out.println("Method Overloading Example:");
        displayArea(new Circle(5.0));
        displayArea(new Rectangle(4.0, 6.0));

        // Method Overriding
        System.out.println("\nMethod Overriding Example:");
        Shape circle = new Circle(3.0);
        Shape rectangle = new Rectangle(5.0, 7.0);

        circle.displayInfo();
        rectangle.displayInfo();
    }

    // Method Overloading
    public static void displayArea(Shape shape) {
        System.out.println("Area: " + shape.calculateArea());
    }
}
