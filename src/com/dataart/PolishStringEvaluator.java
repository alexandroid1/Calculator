package com.dataart;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class PolishStringEvaluator {
    public static int evaluateRPN(Queue<String> queue) {
        Deque<Integer> numstack = new ArrayDeque();
        int first = 0, second = 0;
        while (!queue.isEmpty()) {
            String token = queue.poll();
            if (token.equals("+")) {
                second = numstack.pop();
                first = numstack.pop();
                numstack.push(first + second);
            } else if (token.equals("-")) {
                second = numstack.pop();
                first = numstack.pop();
                numstack.push(first - second);
            } else if (token.equals("*")) {
                second = numstack.pop();
                first = numstack.pop();
                numstack.push(first * second);
            } else if (token.equals("/")) {
                second = numstack.pop();
                first = numstack.pop();
                numstack.push(first / second);
            } else
                numstack.push(Integer.valueOf(token));
        }
        return numstack.pop();
    }
}
