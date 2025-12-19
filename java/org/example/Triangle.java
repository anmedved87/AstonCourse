package org.example;

public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;
    private double h;
    private String fill;
    private String border;

    public Triangle(double a, double b, double c, double h, String fill, String border) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
        this.fill = fill;
        this.border = border;
    }

    @Override
    public double getPerimeter() {
        return triPerimeter(a, b, c);
    }

    @Override
    public double getArea() {
        return triArea(a, h);
    }

    @Override
    public String getFillColor() {
        return fill;
    }

    @Override
    public String getBorderColor() {
        return border;
    }
}
