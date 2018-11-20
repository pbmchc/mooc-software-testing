package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class MirrorTest {
    private Mirror mirror;

    @BeforeEach
    void initialize() {
        mirror = new Mirror();
    }

    @Test()
    void shouldHandleWordsWithEvenNumberOfLetters() {
        Assertions.assertEquals("abc", mirror.mirrorEnds("abcwordcba"));
    }

    @Test()
    void shouldHandleWordsWithOddNumberOfLetters() {
        Assertions.assertEquals("abc", mirror.mirrorEnds("abcacba"));
    }

    @Test()
    void shouldHandleWordsWithOneLetter() {
        Assertions.assertEquals("a", mirror.mirrorEnds("a"));
    }

    @Test()
    void shouldHandlePalindromes() {
        Assertions.assertEquals("ab", mirror.mirrorEnds("abba"));
    }

    @Test()
    void shouldHandleWordWithNoMirrorImagePart() {
        Assertions.assertEquals("", mirror.mirrorEnds("abc"));
    }

    @Test()
    void shouldHandleAnEmptyString() {
        Assertions.assertEquals("", mirror.mirrorEnds(""));
    }

    @Test()
    void shouldThrowIfStringIsNull() {
        Executable nullExecutable =  () -> mirror.mirrorEnds(null);
        Assertions.assertThrows(IllegalArgumentException.class, nullExecutable, "String cannot be null");
    }
}
