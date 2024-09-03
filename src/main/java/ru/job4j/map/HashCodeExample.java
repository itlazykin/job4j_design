package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeExample {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student den = new Student("Den", "Lazykin", 1);
        Student alex = new Student("Alex", "Love", 2);
        Student ivan = new Student("Ivan", "Petrov", 3);
        map.put(den, 10d);
        map.put(alex, 4.34);
        map.put(ivan, 9.34);
        System.out.println(map);
        Student ben = new Student("Ben", "Ten", 5);
        System.out.println(den.hashCode());
        System.out.println(ben.hashCode());
        System.out.println(ben.hashCode());
        System.out.println(ben.hashCode());
        System.out.println(ben.hashCode());
        System.out.println(ben.hashCode());
        System.out.println(ben.hashCode());
        for (Map.Entry<Student, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

   static class Student {
        private final String name;
        private final String surname;
        private final int course;

        public Student(String name, String surname, int course) {
            this.name = name;
            this.surname = surname;
            this.course = course;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Student student = (Student) object;
            return course == student.course
                    && Objects.equals(name, student.name)
                    && Objects.equals(surname, student.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, course);
        }

        @Override
        public String toString() {
            return "Student{" + "name='" + name
                    + '\'' + ", surname='" + surname
                    + '\'' + ", course=" + course + '}';
        }
    }
}
