package org.example;

public class AreaTriangle {

    public double area(double baselength, double height) {
        if (baselength <= 0 || height <= 0) {
            throw new IllegalArgumentException("Число должно быть положительным");
        }
        return 0.5 * baselength * height;
    }
}

