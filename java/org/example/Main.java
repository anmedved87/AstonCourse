package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Бег и плавание");
        Dog dog = new Dog("Тузик");
        Cat cat = new Cat("Смоки", 5);
        dog.run(666);
        dog.swim(5);
        cat.run(170);
        cat.swim(11);
        System.out.println();
        System.out.println("Кол-во животных: " + Animal.count());
        System.out.println("Собак: " + Dog.count());
        System.out.println("Котов: " + Cat.getCatsCount());
        System.out.println();
        System.out.println("Корм для котов");
        Miska bowl = new Miska(25);

        Cat[] cats = {
                new Cat("Мила", 15),
                new Cat("Кеша", 7),
                new Cat("Буся", 10)
        };
        for (Cat c : cats) {
            c.eat(bowl);
            System.out.println("Остаток корма: " + bowl.getFood());
        }

        System.out.println();
        System.out.println("Сытость");
        for (Cat c : cats) {
            System.out.println(c.name + " сыт:" + c.isSatiety());
        }
        System.out.println();
        System.out.println("Добавление корма");
        bowl.addFood(10);
        System.out.println("Остаток корма: " + bowl.getFood());

        System.out.println("Геометрические фигуры");
        Shape circle = new Circle(5, "red", "black");
        Shape rectangle = new Rectangle(4, 6, "blue", "green");
        Shape triangle = new Triangle(3, 4, 5, 2.5, "yellow", "gray");
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
