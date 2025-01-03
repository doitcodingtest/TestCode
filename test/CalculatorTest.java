import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void successAddTwoNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.addTwoNumbers(5,5);
        assertEquals(10,result);
    }

    @Test
    void failAddTwoNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.addTwoNumbers(5,5);
        assertEquals(12,result);
    }
}