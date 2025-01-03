import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnnotationTest {
    @Test
    void normalTest() {
        Calculator calculator = new Calculator();
        int result = calculator.addTwoNumbers(5, 5);
        assertEquals(10, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5,10"})
    void parameterTest(int number1, int number2, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.addTwoNumbers(number1, number2);
        assertEquals(expected, result);
    }

    @RepeatedTest(3)
    void RepeatedTest(RepetitionInfo repetitionInfo) {
        Calculator calculator = new Calculator();
        int result = calculator.addTwoNumbers(5, 5);
        assertEquals(10, result);
        System.out.println("테스트 " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }
}
