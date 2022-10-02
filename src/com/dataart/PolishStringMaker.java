package com.dataart;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class PolishStringMaker {
    public static int calculate(String s) {
        Queue<String> queue = new ArrayDeque();
        Deque<Character> stack = new ArrayDeque();
        int len = s.length();
        boolean checkUnary = true;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c))
                continue;
            if (checkUnary) {
                checkUnary = false;
                if (c == '+' || c == '-')
                    queue.add("0");
            }
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                queue.add(String.valueOf(num));
            } else if (c == '(') {
                checkUnary = true;
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(')
                    queue.add(String.valueOf(stack.pop()));

                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && PolishStringMaker.getPrecedence(c) <= PolishStringMaker.getPrecedence(stack.peek()))
                    queue.add(String.valueOf(stack.pop()));

                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            queue.add(String.valueOf(stack.pop()));
        return PolishStringEvaluator.evaluateRPN(queue);
    }

    private static int getPrecedence(char c) {
        if (c == '*' || c == '/')
            return 2;
        else // '+' or '-'
            return 1;
    }
}
