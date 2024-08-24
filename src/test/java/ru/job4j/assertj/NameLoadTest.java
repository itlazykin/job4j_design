package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkEmptyArray() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasStackTraceContaining("empty");
    }

    @Test
    void checkWrongFormat() {
        NameLoad nameLoad = new NameLoad();
        String value = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(value)
                .hasMessageContaining("not contain the symbol '='");
    }

    @Test
    void checkEmptyKey() {
        NameLoad nameLoad = new NameLoad();
        String value = "=key";
        assertThatThrownBy(() -> nameLoad.parse(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(value)
                .hasMessageContaining("not contain a key");
    }

    @Test
    void checkEmptyValue() {
        NameLoad nameLoad = new NameLoad();
        String value = "value=";
        assertThatThrownBy(() -> nameLoad.parse(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(value)
                .hasMessageContaining("not contain a value");
    }
}