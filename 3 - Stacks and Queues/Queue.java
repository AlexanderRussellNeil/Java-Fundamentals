public class Queue {
    private Object[] items;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) 
    {
        this.items = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public Object enqueue(Object item) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            items[rear] = item;
            size++;
        } else {
            throw new IllegalStateException("enqueue to a full queue");
        }
        return item;
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Object dequeuedItem = items[front];
            front = (front + 1) % capacity;
            size--;
            return dequeuedItem;
        } else {
            throw new IllegalStateException("dequeue from an empty queue");
        }
    }

    public Object front() {
        if (!isEmpty()) {
            return items[front];
        } else {
            throw new IllegalStateException("front from an empty queue");
        }
    }

    public int size() {
        return size;
    }
}