package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RomanNumeralConverterTest {
    private RomanNumeralConverter roman;

    @BeforeEach
    void initialize() {
        roman = new RomanNumeralConverter();
    }

    @Test
    void shouldConvertASingleNumber() {
        Assertions.assertEquals(1, roman.convert("I"));
    }

    @Test
    void shouldConvertAComplexNumber() {
        Assertions.assertEquals(8, roman.convert("VIII"));
    }

    @Test
    void shouldConvertANumberWithSubtractNotation() {
        Assertions.assertEquals(4, roman.convert("IV"));
    }

    @Test
    void shouldConvertAComplexNumberWithSubtractNotation() {
        Assertions.assertEquals(999, roman.convert("CMXCIX"));
    }

    @Test
    void shouldConvertANumberWithVariousNotations() {
        Assertions.assertEquals(64, roman.convert("LXIV"));
    }

    @Test
    void shouldConvertALargeAndComplexNumber() {
        Assertions.assertEquals(3448, roman.convert("MMMCDXLVIII"));
    }

    @Test
    void shouldThrowExceptionIfNumberIsTooLarge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> roman.convert("MMMM"), "Invalid roman numeral");
    }

    @Test
    void shouldThrowExceptionIfNumeralIsNotValid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> roman.convert("XXXX"), "Invalid roman numeral");
    }

    @Test
    void shouldThrowExceptionIfNumeralContainsInvalidCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> roman.convert("XXVB2"), "Invalid roman numeral");
    }
}
