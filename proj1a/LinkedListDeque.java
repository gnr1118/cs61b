public class LinkedListDeque<T> {
    private static class Node<T> {
        private final T item;
        private Node<T> prev;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
            this.prev = this;
            this.next = this;
        }
    }

    private final Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(null);
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        node.prev = sentinel;
        node.next = sentinel.next;
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }

    public void addLast(T item) {
        Node<T> node = new Node<>(item);
        node.prev = sentinel.prev;
        sentinel.prev.next = node;
        node.next = sentinel;
        sentinel.prev = node;
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

        Node<T> node = sentinel.next;

        if (node != sentinel) {
            System.out.print(node.item);
            node = node.next;
        }

        while (node != sentinel) {
            System.out.print(" " + node.item);
            node = node.next;
        }

        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> first = sentinel.next;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        first.next = null;
        first.prev = null;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        last.prev = null;
        last.next = null;
        size--;
        return last.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

        Node<T> node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(Node<T> node, int index) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursive(node.next, index - 1);
        }
    }
}
