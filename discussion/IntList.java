public class IntList {
    private int first;
    private IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    public static IntList squareWithRecursion(IntList L) {
        if (L == null) {
            return L;
        }
        IntList rest = square(L.rest);
        return new IntList(L.first * L.first, rest);
    }

    public static IntList squareMutativeWithRecursion(IntList L) {
        if (L == null) {
            return L;
        }
        L.first *= L.first;
        L.rest = square(L.rest);
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
}