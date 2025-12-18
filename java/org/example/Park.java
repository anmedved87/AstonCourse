package org.example;

public class Park {

    private String name;

    public Park(String name) {
        this.name = name;
    }

    public class Attraction {
        private String nameAttraction;
        private String time;
        private double price;

        public Attraction(String nameAttraction, String time, double price) {
            this.nameAttraction = nameAttraction;
            this.time = time;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Парк: " + name);
            System.out.println("Название аттракциона: " + nameAttraction);
            System.out.println("Время работы: " + time);
            System.out.println("Стоимость: " + price + "BYN");
            System.out.println();
        }
    }
}
