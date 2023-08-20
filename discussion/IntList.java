public class IntList {
    private int first;
    private IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    /** Return the size of the list using recursion */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    /** Return the size of the list using iteration */
    public int iterativeSize() {
        IntList p = this.rest;
        int size = 1;
        while (p != null) {
            size++;
            p = p.rest;
        }
        return size;
    }

    /** Return the ith item of this IntList using recusion */
    public int get(int i) {
        validateIndex(i);
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /** Return the ith item of this IntList using iteration */
    public int iterativeGet(int i) {
        IntList p = this;
        while (i > 0) {
            validateIndex(i, p.rest);
            i--;
            p = p.rest;
        }
        return p.first;
    }

    private void validateIndex(int i) throws IndexOutOfBoundsException {
        validateIndex(i, this.rest);
    }

    private void validateIndex(int i, IntList rest) {
        if (i < 0 || (i > 0 && rest == null)) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n ;i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            p = p.rest;
            n++;
        }
    }

    public static IntList squareWithRecursion(IntList L) {
        if (L == null) {
            return L;
        }
        IntList rest = squareWithRecursion(L.rest);
        return new IntList(L.first * L.first, rest);
    }

    public static IntList squareMutativeWithRecursion(IntList L) {
        if (L == null) {
            return L;
        }
        L.first *= L.first;
        L.rest = squareMutativeWithRecursion(L.rest);
        return L;
    }

    public static IntList squareWithIteration(IntList L) {
        if (L == null) {
            return L;
        }
        IntList LSquared = new IntList(L.first * L.first, null);
        IntList B = L.rest;
        IntList C = LSquared;
        while (B != null) {
            C.rest = new IntList(B.first * B.first, null);
            B = B.rest;
            C = C.rest;
        }
        return LSquared;
    }

    public static IntList squareMutativeWithIteration(IntList L) {
        IntList B = L;
        while (B != null) {
            B.first *= B.first;
            B = B.rest;
        }
        return L;
    }

    public static IntList incrWithRecursion(IntList L, int x) {
        if (L == null) {
            return null;
        }
        IntList rest = incrWithRecursion(L.rest, x);
        return new IntList(L.first + x, rest);
    }

    public static IntList incrMutativeWithRecursion(IntList L, int x) {
        if (L == null) {
            return null;
        }
        L.first += x;
        L.rest = incrWithRecursion(L.rest, x);
        return L;
    }

    public static IntList incrWithIteration(IntList L, int x) {
        if (L == null) {
            return L;
        }
        IntList LIncreased = new IntList(L.first + x, null);
        IntList B = L.rest;
        IntList C = LIncreased;
        while (B != null) {
            C.rest = new IntList(B.first + x, null);
            B = B.rest;
            C = C.rest;
        }
        return LIncreased;
    }

    public static IntList incrMutativeWithIteration(IntList L, int x) {
        IntList B = L;
        while (B != null) {
            B.first += x;
            B = B.rest;
        }
        return L;
    }

    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }
        IntList current = p.rest;
        IntList previous = p;
        while (current != null) {
            if (current.first == previous.first) {
                previous.rest = current.rest;
            } else {
                previous = current;
            }
            current = current.rest;
        }
    }
}