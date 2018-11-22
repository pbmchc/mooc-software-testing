package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountLettersTest {
    private CountLetters countLetters;

    @BeforeEach
    void initialize() {
        countLetters = new CountLetters();
    }

    @Test
    void multipleMatchingWords() {
        int words = countLetters.count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    void firstWordEndsWithR() {
        int words = countLetters.count("bear|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    void lastWordEndsWithR() {
        int words = countLetters.count("cat|bear");
        Assertions.assertEquals(1, words);
    }

    @Test
    void firstWordDoesNotMatch() {
        int words = countLetters.count("cat|dogs");
        Assertions.assertEquals(1, words);
    }

    @Test
    void lastWordDoesNotMatch() {
        int words = countLetters.count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    void noMatchingWords() {
        int words = countLetters.count("cat|dog");
        Assertions.assertEquals(0, words);
    }
}