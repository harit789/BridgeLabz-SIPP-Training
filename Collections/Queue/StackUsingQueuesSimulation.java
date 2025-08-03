import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

class MyStack<T> {
    private Queue<T> q1;
    private Queue<T> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(T x) {
        q1.add(x);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        T topElement = q1.remove();

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        T topElement = q1.peek();

        q2.add(q1.remove());

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }
}

public class StackUsingQueuesSimulation {
    public static void main(String[] args) {
        System.out.println("--- Implement a Stack Using Queues ---");

        MyStack<Integer> stack = new MyStack<>();

        System.out.println("Pushing elements: 1, 2, 3");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack size: " + stack.size());

        System.out.println("Top element: " + stack.top());
        System.out.println("Stack size after top: " + stack.size());

        System.out.println("Popping element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());

        System.out.println("Top element: " + stack.top());
        System.out.println("Popping element: " + stack.pop());
        System.out.println("Popping element: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());

        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
