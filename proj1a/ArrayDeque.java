public class ArrayDeque<T> {
    private final T[] items;
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
            // resize
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            // resize
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

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        System.out.println(deque.isEmpty());
        deque.addFirst(1);
        deque.addLast(5);
        deque.addLast(10);
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
        deque.printDeque();

        System.out.println(deque.get(0) + " " + deque.get(1) + " " + deque.get(2) + " " + deque.get(3));

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
        deque.printDeque();

        System.out.println(deque.removeFirst());
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
        deque.printDeque();

        deque.addFirst(1);
        deque.addLast(5);
        deque.addLast(10);
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
        deque.printDeque();
    }
}
