package org.example;

public interface Shape {

    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }

    default double circlePerimeter(double r) {
        return 2 * Math.PI * r;
    }

    default double circleArea(double r) {
        return Math.PI * r * r;
    }

    default double rectPerimeter(double w, double h) {
        return 2 * (w + h);
    }

    default double rectArea(double w, double h) {
        return w * h;
    }

    default double triPerimeter(double a, double b, double c) {
        return a + b + c;
    }

    default double triArea(double base, double height) {
        return 0.5 * base * height;
    }
}
