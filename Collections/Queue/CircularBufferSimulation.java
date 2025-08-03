import java.util.Arrays;
import java.util.NoSuchElementException;

class CircularBuffer<T> {
    private T[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer.");
        }
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void add(T element) {
        buffer[tail] = element;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = tail;
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Buffer is empty. Cannot remove.");
        }

        T element = buffer[head];
        buffer[head] = null;
        head = (head + 1) % capacity;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Buffer is empty. Cannot peek.");
        }
        return buffer[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(buffer[(head + i) % capacity]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {
        System.out.println("--- Circular Buffer Simulation ---");

        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);
        System.out.println("Buffer created with capacity: " + buffer.capacity());
        System.out.println("Initial buffer: " + buffer + ", Size: " + buffer.size());

        System.out.println("\n--- Inserting elements ---");
        buffer.add(1);
        System.out.println("Added 1. Buffer: " + buffer + ", Size: " + buffer.size());
        buffer.add(2);
        System.out.println("Added 2. Buffer: " + buffer + ", Size: " + buffer.size());
        buffer.add(3);
        System.out.println("Added 3. Buffer: " + buffer + ", Size: " + buffer.size() + ", Full: " + buffer.isFull());

        System.out.println("\n--- Inserting when full (overwrites oldest) ---");
        buffer.add(4);
        System.out.println("Added 4. Buffer: " + buffer + ", Size: " + buffer.size());
        buffer.add(5);
        System.out.println("Added 5. Buffer: " + buffer + ", Size: " + buffer.size());

        System.out.println("\n--- Removing elements ---");
        System.out.println("Removed: " + buffer.remove() + ". Buffer: " + buffer + ", Size: " + buffer.size());
        System.out.println("Removed: " + buffer.remove() + ". Buffer: " + buffer + ", Size: " + buffer.size());

        System.out.println("\n--- Adding more elements ---");
        buffer.add(6);
        System.out.println("Added 6. Buffer: " + buffer + ", Size: " + buffer.size());
        buffer.add(7);
        System.out.println("Added 7. Buffer: " + buffer + ", Size: " + buffer.size());
        buffer.add(8);
        System.out.println("Added 8. Buffer: " + buffer + ", Size: " + buffer.size());

        System.out.println("\n--- Emptying buffer ---");
        while (!buffer.isEmpty()) {
            System.out.println("Removed: " + buffer.remove() + ". Buffer: " + buffer + ", Size: " + buffer.size());
        }
        System.out.println("Is buffer empty? " + buffer.isEmpty());

        System.out.println("\n--- Testing edge cases ---");
        try {
            buffer.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        try {
            buffer.peek();
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
