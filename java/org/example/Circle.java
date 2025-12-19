package org.example;

public class Circle implements Shape {

    private double r;
    private String fill;
    private String border;

    public Circle(double r, String fill, String border) {
        this.r = r;
        this.fill = fill;
        this.border = border;
    }

    @Override
    public double getPerimeter() {
        return circlePerimeter(r);
    }

    @Override
    public double getArea() {
        return circleArea(r);
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
