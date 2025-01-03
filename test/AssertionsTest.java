import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    void AssertEqualsTest() {
        assertEquals(1, 1);
    }
    @Test
    void AssertEqualsArrayTest() {
        int[] A = {1, 2, 3};
        int[] B = {1, 2, 3};
        assertArrayEquals(A, B);
    }
    @Test
    void AssertIterableEqualsTest() {
        Iterable<String> arrayList = new ArrayList<>(asList("A", "B", "C"));
        Iterable<String> linkedList = new LinkedList<>(asList("A", "B", "C"));
        assertIterableEquals(arrayList, linkedList);
    }
    @Test
    void AssertLinesMatchTest() {
        List<String> expected = asList("A", "B");
        List<String> actual = asList("A", "B");
        assertLinesMatch(expected, actual);

    }
    @Test
    void AssertSameTest() {
        String A = "TEST";
        String B = "TEST";
        assertSame(A, B);
    }
    @Test
    void AssertNotEqualsTest() {
        assertNotEquals(1, 2);
    }
    @Test
    void AssertNotSameTest() {
        String A = "TEST";
        String B = "TEST2";
        assertNotSame(A, B);
    }
    @Test
    void AssertTrueTest() {
        assertTrue(true);
    }
    @Test
    void AssertFalseTest() {
        assertFalse(false);
    }
    @Test
    void AssertNullTest() {
        assertNull(null);
    }
    @Test
    void AssertNotNullTest() {
        assertNotNull(new Object());
    }
    @Test
    public void AssertAllTest() {
        assertAll(
                "SET",
                () -> assertEquals(2, 1 + 1),
                () -> assertNull(null),
                () -> assertTrue(true)
        );
    }
    @Test
    void AssertThrowsTest() {
        assertThrows(
                Exception.class,
                () -> {
                    throw new Exception("Exception message");
                }
        );
    }
    @Test
    void AssertTimeoutTest() {
        assertTimeout(Duration.ofMillis(200), () -> {
            Thread.sleep(300);
            System.out.println("오래 걸려도 출력합니다.");
        });

    }
    @Test
    void AssertTimeoutPreemptivelyTest() {
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Thread.sleep(300);
            System.out.println("오래 걸리면 출력하지 않습니다.");
        });

    }
    @Test
    void AssertFailTest() {
        fail();
    }
}
