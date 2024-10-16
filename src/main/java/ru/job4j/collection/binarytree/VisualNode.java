package ru.job4j.collection.binarytree;

/**
 * Для того чтобы вывод на консоль был корректным, узел бинарного дерева для должен реализовывать интерфейс VisualNode.
 * Его главная особенность - представление ключа узла в виде строки
 */
public interface VisualNode {
    VisualNode getLeft();

    VisualNode getRight();

    String getText();
}
