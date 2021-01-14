package condexample;

public class Conditions {

	static int invert(int x) {
		if (x != 3) {
			return 3;
		} else {
			return 4;
		}
	}

	static boolean deMorgan(int x) {
		return !(x != 5 && x != 7);
	}

	static int join_if_conditons_with_AND(int x, int y) {
		if (x == 3) {
			if (y == 4) {
				return x + y;
			}
		}
		return 0;
	}

	static int split_if_AND_conditons(int x, int y) {
		if (x == 3 && y == 4) {
			return x + y;
		} else {
			return 0;
		}
	}

	static boolean join_if_conditons_with_OR(int x, int y) {
		if (x >= 0) {
			return true;
		}
		if (y <= 3) {
			return true;
		}
		return y == 10;
	}

	static boolean split_if_conditons_with_OR(int x, int y) {
		if (x >= 0 || y <= 3 || y == 10) {
			return true;
		}
		return false;
	}

	static int redundant_else(int x) {
		if (x < 3) {
			return 1;
		} else if (x < 10) {
			return 10;
		}
		if (x < 30) {
			return 30;
		} else {
			return 0;
		}
	}

	static int join_statement_blocks(int x, int y) {
		int factor = 1;
		if (x > 3) {
			factor = x;
		}
		int result = 0;
		if (x > 3) {
			result += y * 3;
		}
		return result * factor;
	}

	static int split_statements_blocks(int x, int y) {
		int result = 0;
		int factor = 1;
		if (x > 3) {
			result += y * 3;
			factor = x;
		}
		return result * factor;
	}

	static int group_by(String s1, String s2) {
		if (!s1.equals("hello")) {
			if (!s2.equals("world")) {
				if (!s1.equals("foo")) {
					return 6;
				}
				return 1;
			} else if (!s1.equals("foo")) {
				return 2;
			}
		} else {
			if (s2.equals("bar")) {
				return 3;
			} else if (!s2.equals("world")) {
				return 4;
			}
			return 5;
		}
		return 0;
	}

}
