package ru.job4j.ood.isp;

public class Dogs implements AnimalAction {
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleep");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dogs can't fly");
    }

    @Override
    public void swim() {
        System.out.println("Dog swim");
    }
}
