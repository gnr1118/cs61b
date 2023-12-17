import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void sameCharShouldNotEqual() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('b', 'b'));
    }

    @Test
    public void twoCharactersWhichOffByOneShouldEqual() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('q', 'r'));
    }

    @Test
    public void twoCharactersWhichNotOffByOneShouldNotEqual() {
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('b', 'f'));
        assertFalse(offByOne.equalChars('d', 's'));
        assertFalse(offByOne.equalChars('c', 'x'));
    }
}
