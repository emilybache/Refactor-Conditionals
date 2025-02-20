package condexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleConditionalsTest {

    @ParameterizedTest
    @CsvSource({
            "4, 3",
            "0, 9"
    })
    void guard_clause(int expected, int input) {
        ExampleConditionals.y = 0;
        ExampleConditionals.guard_clause(input);
        assertEquals(expected, ExampleConditionals.y);
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3",
            "3, 5",
            "3, 1",
            "3, 4"
    })
    void invert(int expected, int actual) {
        assertEquals(expected, ExampleConditionals.invert(actual));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "7, 10",
            "29, 30",
            "30, 0"
    })
    void join_statements(int x, int expected) {
        assertEquals(expected, ExampleConditionals.redundant_else(x));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    void deMorganAnd_true(int valid) {
        Assertions.assertTrue(ExampleConditionals.deMorganAnd(valid));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 8})
    void deMorganAnd_false(int invalid) {
        Assertions.assertFalse(ExampleConditionals.deMorganAnd(invalid));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    void deMorganOr_true(int valid) {
        Assertions.assertTrue(ExampleConditionals.deMorganOr(valid));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 8})
    void deMorganOr_false(int invalid) {
        Assertions.assertFalse(ExampleConditionals.deMorganOr(invalid));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3, 0",
            "7, 3, 0",
            "1, 3, 0",
            "3, 4, 7",
            "3, 11, 0"
    })
    void join_AND(int x, int y, int expected) {
        assertEquals(expected, ExampleConditionals.join_AND(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3, 0",
            "7, 3, 0",
            "1, 3, 0",
            "3, 4, 7",
            "3, 11, 0"
    })
    void split_AND(int x, int y, int expected) {
        assertEquals(expected, ExampleConditionals.split_AND(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 3, true",
            "3, 6, true",
            "-1, 3, true",
            "-1, 5, false",
            "-1, 10, true"
    })
    void join_OR(int x, int y, boolean expected) {
        assertEquals(expected, ExampleConditionals.join_OR(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 3, true",
            "3, 6, true",
            "-1, 3, true",
            "-1, 5, false",
            "-1, 10, true"
    })
    void split_OR(int x, int y, boolean expected) {
        assertEquals(expected, ExampleConditionals.split_OR(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3, 36",
            "7, 3, 63",
            "1, 3, 0",
            "3, 4, 0"
    })
    void split_statements(int x, int y, int expected) {
        assertEquals(expected, ExampleConditionals.split_statements(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3, 36",
            "7, 3, 63",
            "1, 3, 0",
            "3, 4, 0"
    })
    void join_statements(int x, int y, int expected) {
        assertEquals(expected, ExampleConditionals.join_statements(x, y));
    }

    @Test
    public void testA_True_B_True() {
        assertEquals("ATrueBTrue", ExampleConditionals.liftUpSimple(true, true));
    }

    @Test
    public void testA_True_B_False() {
        assertEquals("ATrueBFalse", ExampleConditionals.liftUpSimple(true, false));
    }

    @Test
    public void testA_False_B_True() {
        assertEquals("AFalseBTrue", ExampleConditionals.liftUpSimple(false, true));
    }

    @Test
    public void testA_False_B_False() {
        assertEquals("AFalseBFalse", ExampleConditionals.liftUpSimple(false, false));
    }


    @ParameterizedTest
    @CsvSource({
            "foo,   world, 0",
            "foo,   bar,   1",
            "bar,   world, 2",
            "hello, bar,   3",
            "hello, foo,   4",
            "hello, world, 5",
            "bar,   foo,   6",
    })
    void normalize(String s1, String s2, int expected) {
        assertEquals(expected, ExampleConditionals.normalize(s1, s2));
    }

}