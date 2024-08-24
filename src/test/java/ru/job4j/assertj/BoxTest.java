package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void getAreaTetrahedron() {
        Box box = new Box(4, 8);
        double area = box.getArea();
        assertThat(area).isEqualTo(110.85d, withPrecision(0.01d))
                .isGreaterThan(110.85d)
                .isLessThan(111d)
                .isPositive();
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 2);
        double area = box.getArea();
        assertThat(area).isNotZero()
                .isEqualTo(50.26d, withPrecision(0.01d))
                .isCloseTo(50.26d, Percentage.withPercentage(0.1d))
                .isGreaterThan(50.25d)
                .isLessThan(51);
    }

    @Test
    void cubeVertices() {
        Box box = new Box(8, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8)
                .isPositive()
                .isEven()
                .isNotZero();
    }

    @Test
    void sphereVertices() {
        Box box = new Box(0, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isZero();
    }

    @Test
    void tetrahedronVertices() {
        Box box = new Box(4, 8);
        int result = box.getNumberOfVertices();
        assertThat(result).isEven()
                .isNotZero()
                .isNotNegative()
                .isNotNull()
                .isEqualTo(4);
    }

    @Test
    void cubeExist() {
        Box box = new Box(8, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void cubeNotExist() {
        Box box = new Box(7, 10);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }
}