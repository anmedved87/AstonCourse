package org.example;

public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;
    private double heightToA; // высота к стороне a
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, double heightToA, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.heightToA = heightToA;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return trianglePerimeter(a, b, c);
    }

    @Override
    public double getArea() {
        return triangleAreaByBaseHeight(a, heightToA);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
