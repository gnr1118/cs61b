import java.util.Objects;
import java.util.Optional;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (Objects.isNull(word)) {
            return null;
        }
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length() ;i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
}
