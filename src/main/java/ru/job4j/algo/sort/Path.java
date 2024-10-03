package ru.job4j.algo.sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  71. Simplify Path
 */
public class Path {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String segment : path.split("/")) {
            if (segment.isEmpty() || ".".equals(segment)) {
                continue;
            }
            if ("..".equals(segment)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.offerLast(segment);
            }
        }
        return "/" + String.join("/", stack);
    }
}

