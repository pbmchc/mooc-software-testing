package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GHappyTest {
    private GHappy gHappy;

    @BeforeEach
    void initialize() {
        gHappy = new GHappy();
    }

    @Test()
    void shouldReturnTrueIfStringContainsOneHappyG() {
        Assertions.assertTrue(gHappy.isEveryGHappy("xxggxx"));
    }

    @Test()
    void shouldReturnTrueIfStringContainsMultipleHappyGs() {
        Assertions.assertTrue(gHappy.isEveryGHappy("xxxgggxggx"));
    }

    @Test()
    void shouldReturnFalseIfOneOfGsIsUnhappy() {
        Assertions.assertFalse(gHappy.isEveryGHappy("xxggyygxx"));
    }

    @Test()
    void shouldReturnTrueIfStringConsistsOfOnlyGs() {
        Assertions.assertTrue(gHappy.isEveryGHappy("gg"));
    }

    @Test()
    void shouldReturnTrueIfStringConsistsOfOnlyOneG() {
        Assertions.assertFalse(gHappy.isEveryGHappy("g"));
    }


    @Test
    void shouldThrowIfStringIsNull() {
        Executable nullExecutable = () -> gHappy.isEveryGHappy(null);
        Assertions.assertThrows(IllegalArgumentException.class, nullExecutable, "String does not contain 'g'");
    }

    @Test()
    void shouldThrowIfStringDoesNotContainG() {
        Executable noGExecutable = () -> gHappy.isEveryGHappy("no_valid_letter");
        Assertions.assertThrows(IllegalArgumentException.class, noGExecutable, "String does not contain 'g'");
    }
}
