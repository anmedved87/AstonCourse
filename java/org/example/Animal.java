package org.example;

public class Animal {
    protected String name;
    protected static int countAnimal = 0;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + "м.");
    }


    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + "м.");
    }

    public static int count() {
        return countAnimal;
    }
}
