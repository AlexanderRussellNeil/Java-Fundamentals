public class Stack {
    private Object[] items;
    private int size;

    public Stack(int capacity) {
        this.items = new Object[capacity];
        this.size = 0;
    }

    public Stack() {
        this.items = new Object[1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object item) {
        ensureCapacity();
        items[size++] = item;
    }

    public Object pop() {
        if (!isEmpty()) {
            return items[--size];
        } else {
            throw new IllegalStateException("pop from an empty stack");
        }
    }

    public Object peek() {
        if (!isEmpty()) {
            return items[size - 1];
        } else {
            throw new IllegalStateException("peek from an empty stack");
        }
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == items.length) {
            Object[] newItems = new Object[items.length + 1];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }
    }
}