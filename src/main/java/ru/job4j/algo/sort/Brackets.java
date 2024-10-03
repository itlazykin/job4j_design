package ru.job4j.algo.sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 */
public class Brackets {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (final char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
