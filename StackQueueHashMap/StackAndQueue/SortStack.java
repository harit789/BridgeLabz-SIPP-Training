package StackQueueHashMap.StackAndQueue;

import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sort(stack);
            insertInSortedOrder(stack, top);
        }
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
