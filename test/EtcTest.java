import org.junit.jupiter.api.*;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EtcTest {

    @Test
    @Disabled
    void test() {
        System.out.println("test");
    }

    @Test
    @DisplayName("두 수 더하기 테스트")
    void successAddTwoNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.addTwoNumbers(5,5);
        assertEquals(10,result);
    }

    @Test
    void 두_수_더하기_테스트2() {
        Calculator calculator = new Calculator();
        int result = calculator.addTwoNumbers(5,5);
        assertEquals(10,result);
    }

    @Test
    @Timeout(1)
    void timeoutTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
