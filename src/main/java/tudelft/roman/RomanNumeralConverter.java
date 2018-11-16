package tudelft.roman;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class RomanNumeralConverter {
    private static final String INVALID_NUMERAL_MESSAGE = "Invalid roman numeral";
    private static final Map<Character, Integer> ROMAN_NUMERALS = Map.ofEntries(
            entry('I', 1),
            entry('V', 5),
            entry('X', 10),
            entry('L', 50),
            entry('C', 100),
            entry('D', 500),
            entry('M', 1000)
    );

    int convert(String numeral) {
        int result = IntStream.range(0, numeral.length())
                .reduce(0, (acc, curr) -> convertToNumericValue(numeral, acc, curr));

        if (!numeral.equals(convertToRomanNumeral(result))) {
            throw new IllegalArgumentException(INVALID_NUMERAL_MESSAGE);
        }

        return result;
    }

    private int convertToNumericValue(String numeral, int value, int index) {
        int currentValue = getValue(numeral.charAt(index));
        int nextValue = index + 1 < numeral.length() ? getValue(numeral.charAt(index + 1)) : 0;

        return currentValue < nextValue ? value - currentValue : value + currentValue;
    }

    private String convertToRomanNumeral(int value) {
        StringBuilder result = new StringBuilder();

        while (value > 0 && value < 4000) {
            int nearestValue = getNearestAvailableValue(value);
            int ratio = value / nearestValue;

            if (ratio > 3) {
                int nextValue = getNextValue(nearestValue);
                char nextNumeral = getNumeralByValue(nextValue);

                if (result.length() > 0 && nextNumeral == result.charAt(result.length() - 1)) {
                    nextNumeral = getNumeralByValue(getNextValue(nextValue));
                    result.setLength(result.length() - 1);
                }

                result.append(getNumeralByValue(nearestValue));
                result.append(nextNumeral);
            } else {
                for (int i = 0; i < ratio; i++) {
                    result.append(getNumeralByValue(nearestValue));
                }
            }
            value %= nearestValue;
        }

        return result.toString();
    }

    private int getNearestAvailableValue(int value) {
        return ROMAN_NUMERALS.values().stream()
                .sorted(Collections.reverseOrder())
                .filter(v -> v <= value)
                .findFirst()
                .orElse(0);
    }

    private char getNumeralByValue(int value) {
        return arrangeEntries(entry -> entry.getValue() == value, Map.Entry::getKey)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private int getNextValue(int value) {
        return arrangeEntries(entry -> entry.getValue() > value, Map.Entry::getValue)
                .sorted()
                .findFirst()
                .orElse(0);
    }

    private <T> Stream<T> arrangeEntries(Predicate<? super Map.Entry<Character, Integer>> predicate,
                                         Function<? super Map.Entry<Character, Integer>, T> mapper) {
        return ROMAN_NUMERALS.entrySet().stream()
                .filter(predicate)
                .map(mapper);
    }

    private int getValue(char numeral) {
        if (!ROMAN_NUMERALS.containsKey(numeral)) {
            throw new IllegalArgumentException(INVALID_NUMERAL_MESSAGE);
        }

        return ROMAN_NUMERALS.get(numeral);
    }
}
