package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class GeneratorTest {
    @Disabled
    @Test
    void whenAllKeysArePresentThenGenerateCorrectString() {
        Generator generator = new UsageGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Denis");
        map.put("subject", "you");
        String result = generator.produce(template, map);
        assertThat(result).isEqualTo("I am a Denis, Who are you?");
    }

    @Disabled
    @Test
    void whenMissingKeysThenThrowException() {
        Generator generator = new UsageGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Denis");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Missing key: subject");
    }

    @Disabled
    @Test
    void whenExtraKeysThenThrowException() {
        Generator generator = new UsageGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Denis");
        map.put("subject", "you");
        map.put("extra", "extraValue");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Unexpected key: extra");
    }
}