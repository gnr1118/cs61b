public class LinkedListDeque<T> {
    private static class Node<T> {
        private final T item;
        private Node<T> prev;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }

    private final Node<T> sentinelFront;
    private final Node<T> sentinelBack;
    private int size;

    public LinkedListDeque() {
        sentinelFront = new Node<>(null);
        sentinelBack = new Node<>(null);
        sentinelFront.next = sentinelBack;
        sentinelBack.prev = sentinelFront;
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        node.prev = sentinelFront;
        node.next = sentinelFront.next;
        sentinelFront.next.prev = node;
        sentinelFront.next = node;
        size++;
    }

    public void addLast(T item) {
        Node<T> node = new Node<>(item);
        node.prev = sentinelBack.prev;
        sentinelBack.prev.next = node;
        node.next = sentinelBack;
        sentinelBack.prev = node;
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

        Node<T> node = sentinelFront.next;

        if (node != sentinelBack) {
            System.out.print(node.item);
            node = node.next;
        }

        while (node != sentinelBack) {
            System.out.print(" " + node.item);
            node = node.next;
        }

        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> first = sentinelFront.next;
        first.next.prev = sentinelFront;
        sentinelFront.next = first.next;
        first.next = null;
        first.prev = null;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> last = sentinelBack.prev;
        last.prev.next = sentinelBack;
        sentinelBack.prev = last.prev;
        last.prev = null;
        last.next = null;
        size--;
        return last.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

        Node<T> node;
        if (index < size / 2) {
            node = findNodeFromFront(index);
        } else {
            node = findNodeFromBack(index);
        }

        return node.item;
    }

    private Node<T> findNodeFromFront(int index) {
        Node<T> node = sentinelFront.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private Node<T> findNodeFromBack(int index) {
        Node<T> node = sentinelBack.prev;
        for (int i = size - 1; i > index; i--) {
            node = node.prev;
        }
        return node;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return index < size / 2 ? getRecursiveFromFront(sentinelFront.next, index) :
                getRecursiveFromBack(sentinelBack.prev, size - 1 - index);
    }

    private T getRecursiveFromFront(Node<T> node, int count) {
        if (count == 0) {
            return node.item;
        } else {
            return getRecursiveFromFront(node.next, count - 1);
        }
    }

    private T getRecursiveFromBack(Node<T> node, int count) {
        if (count == 0) {
            return node.item;
        } else {
            return getRecursiveFromBack(node.prev, count - 1);
        }
    }
}
