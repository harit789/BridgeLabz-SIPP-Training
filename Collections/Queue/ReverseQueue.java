import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static <T> void reverse(Queue<T> queue) {
        Stack<T> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Reverse a Queue ---");

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        myQueue.add(40);

        System.out.println("Original Queue: " + myQueue);

        reverse(myQueue);

        System.out.println("Reversed Queue: " + myQueue);

        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("Apple");
        stringQueue.add("Banana");
        stringQueue.add("Cherry");

        System.out.println("Original String Queue: " + stringQueue);
        reverse(stringQueue);
        System.out.println("Reversed String Queue: " + stringQueue);
    }
}
