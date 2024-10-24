package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {
    @Test
    void whenNoEqualsPair() {
        String path = "data/no_equals.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Please check each line "
                        + path
                        + "of the file for the key=value pattern."
        );
    }

    @Test
    void whenNoKeyPair() {
        String path = "data/no_key.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Please check each line "
                        + path
                        + "of the file for the key=value pattern."
        );
    }

    @Test
    void whenNoValuePair() {
        String path = "data/no_value.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Please check each line "
                        + path
                        + "of the file for the key=value pattern."
        );
    }

    @Test
    void whenOnlyEqualsPair() {
        String path = "data/only_equals.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Please check each line "
                        + path
                        + "of the file for the key=value pattern."
        );
    }

    @Test
    void whenPairWithComment() {
        String path = "data/pair_with_comment_and_empty_string.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Den Lazykin");
        assertThat(config.value("port")).isEqualTo("0420 =");
    }

    @Test
    void whenPairWithoutComment() {
        String path = "data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Den Lazykin");
    }
}