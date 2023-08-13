public class AList<T> {
    private T[] items;
    private int size;

    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = item;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T last = items[size - 1];
        items[size - 1] = null;
        size--;
        return last;
    }
}
