package org.example;

public class Rectangle implements Shape {

    private double w;
    private double h;
    private String fill;
    private String border;

    public Rectangle(double w, double h, String fill, String border) {
        this.w = w;
        this.h = h;
        this.fill = fill;
        this.border = border;
    }

    @Override
    public double getPerimeter() {
        return rectPerimeter(w, h);
    }

    @Override
    public double getArea() {
        return rectArea(w, h);
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
