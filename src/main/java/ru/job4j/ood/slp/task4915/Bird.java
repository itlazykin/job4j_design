package ru.job4j.ood.slp.task4915;

public class Bird {
    public void fly() {
        System.out.println("Flying in the sky!");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("I'm sparrow. I can fly");
    }

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        sparrow.fly();
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("I'm bird, but ostrich can't fly!");
    }
}
