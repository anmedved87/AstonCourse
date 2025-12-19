package org.example;

// Простой интерфейс для всех фигур
public interface Shape {

    String getFillColor();

    String getBorderColor();

    double getPerimeter();

    double getArea();

    // Готовый метод вывода информации — дефолтный
    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
    }

    // Дефолтные базовые формулы — чтобы классы могли их использовать
    // Круг
    default double circlePerimeter(double r) {
        return 2 * Math.PI * r;
    }

    default double circleArea(double r) {
        return Math.PI * r * r;
    }

    // Прямоугольник
    default double rectanglePerimeter(double w, double h) {
        return 2 * (w + h);
    }

    default double rectangleArea(double w, double h) {
        return w * h;
    }

    // Треугольник (периметр по трём сторонам, площадь по основанию и высоте)
    default double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    default double triangleAreaByBaseHeight(double base, double height) {
        return 0.5 * base * height;
    }
}

