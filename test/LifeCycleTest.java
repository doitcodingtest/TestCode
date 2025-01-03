import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LifeCycleTest {
    @BeforeAll
    static void setUp() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void finishAllTasks() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void setUpEachTest() {
        System.out.print("BeforeEach -> ");
    }

    @AfterEach
    void finishAfterEach() {
        System.out.println("-> AfterEach");
    }

    @Test
    void test() {
        System.out.print("test");
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5,10"})
    void parameterTest(int number1, int number2, int expected) {
        System.out.print("parameterTest");
    }

    @RepeatedTest(2)
    void RepeatedTest() {
        System.out.print("RepeatedTest");
    }
}
