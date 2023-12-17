import java.util.Objects;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (Objects.isNull(word)) {
            return null;
        }
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return checkPalindromeIteratively(deque);
    }

    private static boolean checkPalindromeIteratively(Deque<Character> deque) {
        int size = deque.size();
        for (int i = 0; i < size / 2; i++) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPalindromeRecursively(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        if (!deque.removeFirst().equals(deque.removeLast())) {
            return false;
        }
        return checkPalindromeRecursively(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator characterComparator) {
        Deque<Character> deque = wordToDeque(word);
        return checkPalindromeIteratively(deque, characterComparator);
    }

    private static boolean checkPalindromeIteratively(Deque<Character> deque, CharacterComparator characterComparator) {
        int size = deque.size();
        for (int i = 0; i < size / 2; i++) {
            if (!characterComparator.equalChars(deque.removeFirst(), deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPalindromeRecursively(Deque<Character> deque, CharacterComparator characterComparator) {
        if (deque.size() <= 1) {
            return true;
        }
        if (!characterComparator.equalChars(deque.removeFirst(), deque.removeLast())) {
            return false;
        }
        return checkPalindromeRecursively(deque, characterComparator);
    }
}
