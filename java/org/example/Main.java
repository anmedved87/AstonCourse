package org.example;

public class Main {

    public static void main(String[] args) {
        Product product = new Product(
                "Смартфон Apple iPhone 17",
                "01.09.2025",
                "Apple Inc.",
                "Китай",
                3500.03,
                "Забронирован");
        product.printInfo();


        Product[] productArray = new Product[5];

        productArray[0] = new Product(
                "Смартфон Samsung Galaxy A36",
                "03.03.2025",
                "Samsung Corp.",
                "Корея",
                1069,
                "Не забронирован");

        productArray[1] = new Product(
                "Смартфон Xiaomi Redmi 15C",
                "18.02.2025",
                "Xiaomi",
                "Китай",
                469.99,
                "Забронирован");

        productArray[2] = new Product(
                "Смартфон Honor X5c",
                "12.12.2024",
                "Honor Device Co.",
                "Китай",
                596,
                "Забронирован");

        productArray[3] = new Product(
                "Смартфон POCO C71",
                "09.02.2025",
                "POCO ",
                "Китай",
                1003,
                "Забронирован");

        productArray[4] = new Product(
                "Мобильный телефон Nokia 105 TA-1557 DS",
                "05.04.2024",
                "Nokia",
                "Китай",
                106,
                "Не забронирован");
        for (int i = 0; i < productArray.length; i++) {
            productArray[i].printInfo();
        }

        Park park = new Park("Джунгли");

        Park.Attraction a1 = park.new Attraction(
                "Карусель Ромашка",
                "09:00 — 22:00",
                7.50);

        Park.Attraction a2 = park.new Attraction(
                "Батут",
                "09:00 — 22:00",
                10);

        Park.Attraction a3 = park.new Attraction(
                "Поезд",
                "09:00 — 21:00",
                5.5);

        Park.Attraction a4 = park.new Attraction(
                "Карусель Страха",
                "09:00 — 23:00",
                7.5);

        Park.Attraction a5 = park.new Attraction(
                "Колесо обозрения",
                "09:00 — 23:00",
                15);

        a1.printInfo();
        a2.printInfo();
        a3.printInfo();
        a4.printInfo();
        a5.printInfo();
    }
}




