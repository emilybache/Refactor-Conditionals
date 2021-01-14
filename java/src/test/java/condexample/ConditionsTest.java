package condexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConditionsTest {

	@ParameterizedTest
	@ValueSource(ints = { 5, 7 })
	void deMorgan_true(int valid) {
		Assertions.assertTrue(Conditions.deMorgan(valid));
	}

	@ParameterizedTest
	@ValueSource(ints = { 4, 8 })
	void deMorgan_false(int invalid) {
		Assertions.assertFalse(Conditions.deMorgan(invalid));
	}

	@ParameterizedTest
	@CsvSource({ "4, 3", "3, 5", "3, 1", "3, 4" })
	void invert(int expected, int actual) {
		Assertions.assertEquals(expected, Conditions.invert(actual));
	}

	@ParameterizedTest
	@CsvSource({ "4, 3, 0", "7, 3, 0", "1, 3, 0", "3, 4, 7", "3, 11, 0" })
	void split(int x, int y, int expected) {
		Assertions.assertEquals(expected, Conditions.split_if_AND_conditons(x, y));
	}

	@ParameterizedTest
	@CsvSource({ "4, 3, 0", "7, 3, 0", "1, 3, 0", "3, 4, 7", "3, 11, 0" })
	void join(int x, int y, int expected) {
		Assertions.assertEquals(expected, Conditions.join_if_conditons_with_AND(x, y));
	}
	
	
	@ParameterizedTest
	@CsvSource({ "0, 3, true", "3, 6, true", "-1, 3, true", "-1, 5, false", "-1, 10, true"})
	void join_OR(int x, int y, boolean expected) {
		Assertions.assertEquals(expected, Conditions.join_if_conditons_with_OR(x, y));
	}
	
	
	@ParameterizedTest
	@CsvSource({ "0, 3, true", "3, 6, true", "-1, 3, true", "-1, 5, false", "-1, 10, true"})
	void split_OR(int x, int y, boolean expected) {
		Assertions.assertEquals(expected, Conditions.split_if_conditons_with_OR(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({ "4, 3, 36", "7, 3, 63", "1, 3, 0", "3, 4, 0" })
	void split_statements(int x, int y, int expected) {
		Assertions.assertEquals(expected, Conditions.split_statements_blocks(x, y));
	}

	@ParameterizedTest
	@CsvSource({ "4, 3, 36", "7, 3, 63", "1, 3, 0", "3, 4, 0" })
	void join_statements(int x, int y, int expected) {
		Assertions.assertEquals(expected, Conditions.join_statement_blocks(x, y));
	}

	@ParameterizedTest
	@CsvSource({ "2, 1", "7, 10", "29, 30", "30, 0" })
	void join_statements(int x, int expected) {
		Assertions.assertEquals(expected, Conditions.redundant_else(x));
	}
	
	@ParameterizedTest
	@CsvSource({ 
		  "hello, world, 5",
		  "bar,   foo,   6",
		  "foo,   world, 0",
		  "foo,   bar,   1",
		  "bar,   world, 2",
		  "hello, bar,   3",
		  "hello, foo,   4"
		})
	void group_by(String s1, String s2, int expected) {
		Assertions.assertEquals(expected, Conditions.group_by(s1, s2));
	}
	
}


