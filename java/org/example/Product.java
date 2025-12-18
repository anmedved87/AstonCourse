package org.example;

public class Product {

    private String name;
    private String dateProduct;
    private String manuf;
    private String country;
    private double price;
    private String state;

    public Product(String name,
                   String dateProduct,
                   String manuf,
                   String country,
                   double price,
                   String state) {
        this.name = name;
        this.dateProduct = dateProduct;
        this.manuf = manuf;
        this.country = country;
        this.price = price;
        this.state = state;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + dateProduct);
        System.out.println("Производитель: " + manuf);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price + "BYN");
        System.out.println("Состояние бронирования покупателем:" + state);
        System.out.println();
    }
}

