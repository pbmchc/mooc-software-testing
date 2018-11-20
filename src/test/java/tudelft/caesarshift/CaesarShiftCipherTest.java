package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CaesarShiftCipherTest {
    private CaesarShiftCipher caesarShiftCipher;

    @BeforeEach
    void initialize() {
        caesarShiftCipher = new CaesarShiftCipher();
    }

    @ParameterizedTest(name = "message={0}, shift={1}, expected={2}")
    @CsvSource({"abc, 3, def", "test, 0, test", "xyz, 4, bcd"})
    void shouldHandleStringsWithNoWhiteSpacesAndPositiveShift(String message, int shift, String expected) {
        Assertions.assertEquals(expected, caesarShiftCipher.cipher(message, shift));
    }

    @ParameterizedTest(name = "message={0}, shift={1}, expected={2}")
    @CsvSource({"def, -3, abc", "abc, -3, xyz"})
    void shouldHandleStringsWithNoWhiteSpacesAndNegativeShift(String message, int shift, String expected) {
        Assertions.assertEquals(expected, caesarShiftCipher.cipher(message, shift));
    }

    @ParameterizedTest(name = "message={0}, shift={1}, expected={2}")
    @CsvSource({"abc abc abc, 3, def def def", "abc abc, -3, xyz xyz"})
    void shouldHandleStringsWithWhiteSpaces(String message, int shift, String expected) {
        Assertions.assertEquals(expected, caesarShiftCipher.cipher(message, shift));
    }


    @ParameterizedTest(name = "message={0}, shift={1}, expected={2}")
    @CsvSource({"abc 123, 5, invalid", "123, 5, invalid", "a, 5, f"})
    void shouldHandleInvalidStrings(String message, int shift, String expected) {
        Assertions.assertEquals(expected, caesarShiftCipher.cipher(message, shift));
    }

    @Test
    void shouldHandleEmptyString() {
        Assertions.assertEquals("", caesarShiftCipher.cipher("", 10));
    }
}
