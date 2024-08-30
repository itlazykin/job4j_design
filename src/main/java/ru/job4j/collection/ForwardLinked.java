package ru.job4j.collection;

import java.util.*;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        if (size == 0) {
            head = new Node<>(value, null);
        } else {
            Node<T> newNode = head;
            while (newNode.next != null) {
                newNode = newNode.next;
            }
            newNode.next = new Node<>(value, null);
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> newNode = head;
        for (int i = 1; i <= index; i++) {
            newNode = newNode.next;
        }
        return newNode.item;
    }

    public T deleteFirst() {
        final Node<T> f = head;
        if (f == null) {
            throw new NoSuchElementException();
        }
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null;
        head = next;
        size--;
        modCount++;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = currentNode.item;
                currentNode = currentNode.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}