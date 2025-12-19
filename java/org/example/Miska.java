package org.example;

public class Miska {

    private int food;

    public Miska(int food) {
        this.food = Math.max(food, 0);
    }

    public boolean deleteFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
        }
    }

    public int getFood() {
        return food;
    }
}
