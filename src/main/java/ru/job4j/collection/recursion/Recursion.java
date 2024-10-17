package ru.job4j.collection.recursion;

public class Recursion {
    public int loop(int summary, int index) {
        for (int i = index; i > 0; i--) {
            summary += i;
        }
        return summary;
    }

    public int sum(int summary, int index) {
        if (index > 0) {
            summary += index;
            index--;
            summary = sum(summary, index);
        }
        return summary;
    }

    public long factorialLoop(int index) {
        long result = 1L;
        if (index > 0) {
            for (int i = 1; i <= index; i++) {
                result *= i;
            }
        }
        return result;
    }

    public long factorialRecursion(long index) {
        if (index == 0 || index == 1) {
            return 1;
        }
        return index * factorialRecursion(index - 1);
    }

    public long fibonacciLoop(int num) {
        long result = 0L;
        if (num == 1) {
            result = 1L;
        } else if (num > 1) {
            long f1 = 1L;
            long f2 = 1L;
            for (int i = 0; i < (num - 2); i++) {
                result = f2 + f1;
                f1 = f2;
                f2 = result;
            }
        }
        return result;
    }

    public long fibonacciRecursion(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
    }
}
