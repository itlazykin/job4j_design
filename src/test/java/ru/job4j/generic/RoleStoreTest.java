package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsDen() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Den");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        Role result = roleStore.findById("11");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsDen() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.add(new Role("1", "Ben"));
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Den");
    }

    @Test
    void whenReplaceThenUsernameIsBen() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.replace("1", new Role("1", "Ben"));
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Ben");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.replace("11", new Role("1", "Ben"));
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Den");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.delete("1");
        Role result = roleStore.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsPetr() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.delete("11");
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Den");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        boolean result = roleStore.replace("1", new Role("1", "Ben"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        boolean result = roleStore.replace("11", new Role("1", "Ben"));
        assertThat(result).isFalse();
    }
}