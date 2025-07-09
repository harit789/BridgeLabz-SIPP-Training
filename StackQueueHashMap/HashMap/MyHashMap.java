package StackQueueHashMap.HashMap;

class MyHashMap {

    private static class Node {

        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2, 30);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
