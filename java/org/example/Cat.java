package org.example;

public class Cat extends Animal {

    private static int countCat = 0;
    private boolean satiety = false;
    private int countfood;

    public Cat(String name, int appetite) {
        super(name);
        this.countfood = appetite;
        countCat++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Miska miska) {
        if (miska.deleteFood(countfood)) {
            satiety = true;
            System.out.println(name + " корма хватило");
        } else {
            System.out.println(name + " корма не хватило");
        }
    }


    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatsCount() {
        return countCat;
    }
}
