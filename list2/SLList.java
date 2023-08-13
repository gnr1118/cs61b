package list2;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int... ints) {
        this();
        IntNode p = sentinel;
        for (int x : ints) {
            p.next = new IntNode(x, null);
            p = p.next;
            size++;
        }
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size++;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public void deleteFirst() {
        if (sentinel.next == null) {
            return;
        }
        sentinel.next = sentinel.next.next;
        size--;
    }

    public void insert(int x, int position) {
        IntNode p = sentinel;
        for (int i = 0; i < position && p.next != null ;i++) {
            p = p.next;
        }
        p.next = new IntNode(x, p.next);
        size++;
    }

    public void reverse() {
        IntNode f = null;
        IntNode n = sentinel.next;
        while (n != null) {
            IntNode tmp = n.next;
            n.next = f;
            f = n;
            n = tmp;
        }
        sentinel.next = f;
    }

    public void reverseWithRecursion() {
        sentinel.next = reverseHelper(sentinel.next);
    }

    private static IntNode reverseHelper(IntNode f) {
        if (f == null || f.next == null) {
            return f;
        } else {
            IntNode reversed = reverseHelper(f.next);
            f.next.next = f;
            f.next = null;
            return reversed;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.deleteFirst();
        L.reverseWithRecursion();
        System.out.println(L.size());

        SLList L2 = new SLList(5, 10, 15, 20, 25);
        L2.insert(0, 0);
        L2.reverseWithRecursion();
        System.out.println(L2.size());

        SLList L3 = new SLList(5);
        L3.reverseWithRecursion();
        System.out.println(L3.size);
    }
}
