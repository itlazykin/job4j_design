package ru.job4j.ood.slp.task4915;

public class TransportPark {
    public void ride() {
        System.out.println("Я доеду по дороге из пункта А в пункт Б");
    }
}

class Car extends TransportPark {
    @Override
    public void ride() {
        System.out.println("На машине можно доехать по дороге из пункта А в пункт Б");
    }
}

class Bicycle extends TransportPark {
    @Override
    public void ride() {
        System.out.println("На велосипеде можно доехать по дороге из пункта А в пункт Б");
    }
}

class Motorbike extends TransportPark {
    @Override
    public void ride() {
        System.out.println("На мотоцикле можно доехать по дороге из пункта А в пункт Б");
    }
}

class Boat extends TransportPark {
    @Override
    public void ride() {
        throw new UnsupportedOperationException("На ложке нельзя ехать по дороге, она умеет только ехать по воде");
    }
}
