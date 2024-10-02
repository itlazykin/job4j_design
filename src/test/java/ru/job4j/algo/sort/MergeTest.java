package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenArrayWithSameElementsThenSorted() {
        int[] array = {2, 2, 2, 2, 2};
        int[] sorted = Merge.mergesort(array);
        assertThat(sorted).containsExactly(2, 2, 2, 2, 2);
    }

    @Test
    void whenSingleElementArrayThenSame() {
        int[] array = {13};
        int[] sorted = Merge.mergesort(array);
        assertThat(sorted).containsExactly(13);
    }
}