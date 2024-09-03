package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        User den = new User("Den", 2, calendar);
        int hashCodeDen = den.hashCode();
        int hashDen = hashCodeDen ^ (hashCodeDen >>> 16);
        int bucketDen = hashDen & 15;
        User ben = new User("Den", 2, calendar);
        int hashCodeBen = ben.hashCode();
        int hashBen = hashCodeBen ^ (hashCodeBen >>> 16);
        int bucketBen = hashBen & 15;
        Map<User, Object> map = new HashMap<>(16);
        map.put(den, new Object());
        map.put(ben, new Object());
        System.out.println(map);
        System.out.println("Без переопределения equals и hashCode");
        System.out.println("Пары попали в разные корзины");
        System.out.println("Проверка ключей на равенство по hashcode и equals не происходила, т.к. ключи расположены в "
                + "разных бакетах, и сравнение не производится");
        System.out.println();
        System.out.println("Переопределить только hashCode");
        System.out.println("Пары попали в одну корзину");
        System.out.println("Проверка по hashCode была выполнена, тк мы его переопределили и пары были в одной корзине");
        System.out.println("Проверка по equals производилась, но т.к. этот метод не переопределен в классе юзер, то "
                + "происходило сравнение ссылок на объект, а не значений объекта.");
        System.out.println();
        System.out.println("Переопределить только equals");
        System.out.println("Пары попали в разные корзины, проверка выполняется только когда пары в одной корзине");
        System.out.println();
    }
}
