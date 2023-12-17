import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    static CharacterComparator offByThree = new OffByN(3);

    // Your tests go here.
    @Test
    public void sameCharShouldNotEqual() {
        assertFalse(offByThree.equalChars('a', 'a'));
        assertFalse(offByThree.equalChars('b', 'b'));
    }

    @Test
    public void twoCharactersWhichOffByThreeShouldEqual() {
        assertTrue(offByThree.equalChars('a', 'd'));
        assertTrue(offByThree.equalChars('d', 'a'));
        assertTrue(offByThree.equalChars('t', 'q'));
        assertTrue(offByThree.equalChars('q', 't'));
    }

    @Test
    public void twoCharactersWhichNotOffByThreeShouldNotEqual() {
        assertFalse(offByThree.equalChars('a', 'e'));
        assertFalse(offByThree.equalChars('b', 'f'));
        assertFalse(offByThree.equalChars('d', 's'));
        assertFalse(offByThree.equalChars('c', 'x'));
    }
}