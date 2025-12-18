package org.example;

public class Main {

    public static void main(String[] args) {
        Product product = new Product(
                "Apple iPhone 17 256GB",
                "01.09.2025",
                "Apple Inc. США",
                "Китай",
                3500.03,
                "Забронирован");
        product.printInfo();
    }
}

