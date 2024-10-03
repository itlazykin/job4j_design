package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class QuickListTest {
    @Test
    void whenSortThenOk() {
        User user1 = new User(1, "11");
        User user2 = new User(1, "22");
        User user3 = new User(3, "33");
        User user4 = new User(-4, "44");
        User user5 = new User(4, "55");
        User user6 = new User(6, "66");
        Comparator<User> comparator = Comparator.comparingInt(User::getId);
        List<User> listUser = new ArrayList<>();
        listUser.add(user3);
        listUser.add(user5);
        listUser.add(user1);
        listUser.add(user4);
        listUser.add(user6);
        listUser.add(user2);
        QuickList.quickSort(listUser, comparator);
        List<Integer> result = listUser.stream().map(User::getId).toList();
        assertThat(result).containsExactly(-4, 1, 1, 3, 4, 6);
    }

    @Test
    void whenSortByNameThenOk() {
        User user1 = new User(1, "Bob");
        User user2 = new User(2, "Alice");
        User user3 = new User(3, "Charlie");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user3);
        list.add(user2);
        QuickList.quickSort(list, Comparator.comparing(User::getName));
        List<String> result = list.stream().map(User::getName).toList();
        assertThat(result).containsExactly("Alice", "Bob", "Charlie");
    }

    @Test
    void whenReverseOrderThenOk() {
        Comparator<Integer> comparator = (a, b) -> b - a;
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(-8);
        list.add(1);
        list.add(0);
        list.add(10);
        list.add(1);
        list.add(8);
        QuickList.quickSort(list, comparator);
        System.out.println(list);
        assertThat(list).containsExactly(10, 8, 1, 1, 0, -2, -8);
    }

    @Test
    void whenEmptyListThenOk() {
        List<Integer> list = new ArrayList<>();
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).isEmpty();
    }

    @Test
    void whenSingleElementThenOk() {
        List<Integer> list = new ArrayList<>();
        list.add(47);
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).containsExactly(47);
    }

    @Test
    void whenAllElementsAreSameThenOk() {
        List<Integer> list = new ArrayList<>();
        list.add(47);
        list.add(47);
        list.add(47);
        list.add(47);
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).containsExactly(47, 47, 47, 47);
    }

    @Test
    void whenSortStringsThenOk() {
        List<String> list = new ArrayList<>();
        list.add("banana");
        list.add("apple");
        list.add("cherry");
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).containsExactly("apple", "banana", "cherry");
    }

    private static class User {
        private Integer id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}