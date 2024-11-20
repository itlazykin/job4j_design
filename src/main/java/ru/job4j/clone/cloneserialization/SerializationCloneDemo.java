package ru.job4j.clone.cloneserialization;

public class SerializationCloneDemo {
    public static void main(String[] args) {
        Person original = new Person("John Doe", 30);
        Person cloned = original.deepClone();
        System.out.println("Оригинал: " + original);
        System.out.println("Клон: " + cloned);
        System.out.println("Оригинал и клон — это разные объекты: " + (original != cloned));
    }
}
