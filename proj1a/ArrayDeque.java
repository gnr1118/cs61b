public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }

        int currIndex = plusOne(nextFirst);

        if (currIndex != nextLast) {
            System.out.print(items[currIndex]);
            currIndex = plusOne(currIndex);
        }

        while (currIndex != nextLast) {
            System.out.print(" " + items[currIndex]);
            currIndex = plusOne(currIndex);
        }

        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (size == items.length / 4) {
            resize(items.length / 2);
        }

        int prevNextFirst = plusOne(nextFirst);
        T item = items[prevNextFirst];
        nextFirst = prevNextFirst;
        items[prevNextFirst] = null;
        size--;

        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (size == items.length / 4) {
            resize(items.length / 2);
        }

        int prevNextLast = minusOne(nextLast);
        T item = items[prevNextLast];
        nextLast = prevNextLast;
        items[prevNextLast] = null;
        size--;

        return item;
    }

    public T get(int index) {
        int beginIndex = plusOne(nextFirst);
        int targetIndex = (beginIndex + index) % items.length;
        return items[targetIndex];
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0, j = plusOne(nextFirst); i < size ;i++, j = plusOne(j)) {
            newItems[i] = items[j];
        }
        items = newItems;
        nextFirst = newItems.length - 1;
        nextLast = size;
    }

    private int minusOne(int index) {
        index -= 1;
        if (index < 0) {
            index = items.length - 1;
        }
        return index;
    }

    private int plusOne(int index) {
        index += 1;
        if (index > items.length - 1) {
            index = 0;
        }
        return index;
    }
}
