package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> implements Queue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn;
    private int countOut;

    public T poll() {
        if (countIn == 0 && countOut == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (countOut == 0) {
            while (countIn != 0) {
                out.push(in.pop());
                countIn--;
                countOut++;
            }
        }
        countOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }

    public int size() {
        return countIn + countOut;
    }

    public boolean isEmpty() {
        return countOut == 0;
    }
}
