package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class TwoNumbersSumTest {

    @ParameterizedTest(name = "{0} => {1} + {2} = {3}")
    @MethodSource("argumentsProvider")
    void sumTwoNumbers(String description, ArrayList<Integer> first, ArrayList<Integer> second, ArrayList<Integer> result) {
        Assertions.assertEquals(result, new TwoNumbersSum().addTwoNumbers(first, second));
    }

    private static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of("Sum lower than ten", buildArrayList(1, 2), buildArrayList(2, 2), buildArrayList(3, 4)),
                Arguments.of("Sum higher than ten", buildArrayList(1, 7), buildArrayList(2, 4), buildArrayList(4, 1)),
                Arguments.of("Different size result", buildArrayList(5), buildArrayList(5), buildArrayList(1, 0)),
                Arguments.of("Different size arguments", buildArrayList(1, 9, 1), buildArrayList(5), buildArrayList(1, 9, 6)),
                Arguments.of("Empty arguments", buildArrayList(), buildArrayList(), buildArrayList())
        );
    }

    private static ArrayList<Integer> buildArrayList(Integer ...elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }
}
