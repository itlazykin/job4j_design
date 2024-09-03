package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "Denis Petrov");
        map.put(3244, "Daniil Ser");
        map.put(122, "Alex Love");
        map.put(32344, "Ivan Ivanov");
        map.putIfAbsent(1000, "Denis Petrov");
        map.putIfAbsent(1001, "Denis Petrov");
        System.out.println(map.get(120));
        System.out.println(map.get(122));
        System.out.println(map);
        map.remove(1001);
        System.out.println(map);
        System.out.println(map.containsValue("Denis Petrov"));
        System.out.println(map.containsKey(1223));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
    }
}
