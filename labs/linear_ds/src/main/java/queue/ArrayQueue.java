package queue;

import interfaces.Queue;

public class ArrayQueue implements Queue {
    private int[] queue;

    private int head;
    private int tail;

    private int length;
    private int capacity;

    private static final int defaultCapacity = 8;

    public ArrayQueue() {
        this(defaultCapacity);
    }

    public ArrayQueue(int initialCapacity) {
        queue = new int[initialCapacity];
        head = 0;
        tail = 0;
        length = 0;
        capacity = initialCapacity;
    }

    public boolean enqueue(int e) {
        boolean didChange = false;
        if (length >= capacity) {
            capacity += 20;
            int[] tmp = new int[capacity];
            System.arraycopy(queue, head, tmp, 0, length);
            queue = tmp;
            head = 0;
            tail = length;
            didChange = true;
        }
        queue[tail++] = e;
        length++;
        return didChange;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int dequeue() {
        if (queue.length == 0)
            return 0;
        else {
            length--;
            return queue[head++];
        }
    }

    public int head() {
        return queue[head];
    }

    public int tail() {
        if (tail <= 0)
            return 0;
        else
            return queue[tail - 1];
    }

    public int size() {
        return length;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = head; i < tail; i++)
            res.append(queue[i]).append(" ");
        return res.toString();
    }
}