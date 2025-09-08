// Circle.java
public class Circle {
    double radius;

    // Default constructor
    public Circle() {
        this(1.0); // constructor chaining: default radius 1.0
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }
}
