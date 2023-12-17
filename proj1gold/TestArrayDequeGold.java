import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class TestArrayDequeGold {
    private static final int TEST_ROUND = 1000;

    private final StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
    private final ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
    private final StringBuilder sb = new StringBuilder();
    private Integer studentRemovedNumber = 0;
    private Integer solutionRemovedNumber = 0;

    @Test
    public void testStudentArrayDeque() {
        for (int i = 0; i < TEST_ROUND; i++) {
            if (arrayDequeSolution.isEmpty()) {
                switch (Method.addMethod()) {
                    case ADD_FIRST:
                        addFirst();
                        break;
                    case ADD_LAST:
                        addLast();
                        break;
                }
            } else {
                switch (Method.method()) {
                    case ADD_FIRST:
                        addFirst();
                        break;
                    case ADD_LAST:
                        addLast();
                        break;
                    case REMOVE_FIRST:
                        removeFirst();
                        break;
                    case REMOVE_LAST:
                        removeLast();
                        break;
                }
                assertEquals(String.format("\n%s", sb), solutionRemovedNumber, studentRemovedNumber);
            }
        }
    }

    private void addFirst() {
        int randomNumber = StdRandom.uniform(TEST_ROUND);
        sb.append(String.format("addFirst(%d)\n", randomNumber));
        studentArrayDeque.addFirst(randomNumber);
        arrayDequeSolution.addFirst(randomNumber);
    }

    private void addLast() {
        int randomNumber = StdRandom.uniform(TEST_ROUND);
        sb.append(String.format("addLast(%d)\n", randomNumber));
        studentArrayDeque.addLast(randomNumber);
        arrayDequeSolution.addLast(randomNumber);
    }

    private void removeFirst() {
        sb.append("removeFirst()\n");
        studentRemovedNumber = studentArrayDeque.removeFirst();
        solutionRemovedNumber = arrayDequeSolution.removeFirst();
    }

    private void removeLast() {
        sb.append("removeLast()\n");
        studentRemovedNumber = studentArrayDeque.removeLast();
        solutionRemovedNumber = arrayDequeSolution.removeLast();
    }

    enum Method {
        ADD_FIRST,
        ADD_LAST,
        REMOVE_FIRST,
        REMOVE_LAST;

        public static Method addMethod() {
            int index = StdRandom.uniform(2);
            return List.of(ADD_FIRST, ADD_LAST).get(index);
        }

        public static Method method() {
            int index = StdRandom.uniform(4);
            return Method.values()[index];
        }
    }
}
